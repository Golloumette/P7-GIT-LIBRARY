package fr.library.emprunt;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {
    private final JobLauncher launcher;
    private final Job job;

    public JobScheduler(JobLauncher launcher, Job job) {
        this.launcher = launcher;
        this.job = job;
    }

    @Scheduled(cron = "0 0 6 * * *", zone = "Europe/Paris")
    public void perform() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters parameters = new JobParametersBuilder()
                .addString("MailDeRelanceJobId", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        launcher.run(job, parameters);
    }
}
