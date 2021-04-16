package fr.library.emprunt.config;

import fr.library.emprunt.processor.ReservationProcesor;
import fr.library.emprunt.reader.ReservationReader;
import fr.library.emprunt.model.ReservationEntity;
import fr.library.emprunt.writer.ReservationWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Bean
    ReservationReader reader() {
        return new ReservationReader();
    }

    //methode caro
   /* @Bean
    public ItemReader<ReservationEntity> reservationItemReader(){
        JdbcPagingItemReader<ReservationEntity>reader = new JdbcPagingItemReader<>();
        reader.setDataSource(dataSource);
        reader.setFetchSize(100);
        reader.setPageSize(100);


        return reader;
    }*/

    @Bean
    ReservationProcesor procesor() {

        return new ReservationProcesor();
    }

    @Bean
    ReservationWriter writer() {

        return new ReservationWriter();
    }

    @Bean
    public Job job(Step step) {
        return jobBuilderFactory.get("MailDeRelanceJob")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step(ReservationReader reader, ReservationProcesor procesor, ReservationWriter writer) {
        return stepBuilderFactory.get("MailDeRelanceStep")
                .<ReservationEntity, ReservationEntity>chunk(10)
                .reader(reader)
                .processor(procesor)
                .writer(writer)
                .build();
    }
}
