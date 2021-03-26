package fr.library.emprunt.batch.config;

import fr.library.emprunt.batch.processor.LibraryItemProcessor;
import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.repository.ReservationRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.function.Function;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public ReservationRepository reservationRepository;

    @Bean
    public RepositoryItemReader<ReservationEntity> reader() {
        RepositoryItemReader<ReservationEntity> reservationItemReader = new RepositoryItemReader<>();
        reservationItemReader.setRepository(reservationRepository);
        reservationItemReader.setMethodName("findAll");
        reservationItemReader.setPageSize(40);
        HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.DESC);
        reservationItemReader.setSort(sorts);
        return reservationItemReader;
    }

    @Bean
    public JdbcBatchItemWriter writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO reservation (ouvrageEntity, usagerEntity, dtEmprunt, dtRetour, prevReservationId) VALUES (:ouvrageEntity, :usagerEntity, :dtEmprunt,:dtRetour, : prevReservationId)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public <JobCompletionNotificationListener> Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter writer) {
        return stepBuilderFactory.get("step1")
                .<ReservationEntity, ReservationEntity>chunk(10)
                .reader(reader())
                .processor((Function) processor())
                .writer(writer)
                .build();
    }

    @Bean
    public LibraryItemProcessor processor() {
        return new LibraryItemProcessor();
    }
}
