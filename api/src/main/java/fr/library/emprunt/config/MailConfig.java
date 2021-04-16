package fr.library.emprunt.config;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.security.GeneralSecurityException;
import java.util.Properties;

@Configuration
public class MailConfig {


    @Bean
    public JavaMailSender getJavaMailSender() throws GeneralSecurityException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("golloumette59@gmail.com");
        mailSender.setPassword("Kerigan1");
       // mailSender.setPassword("ebqvcepscyknggqr");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.protocol.ssl.trust", "*");
        props.put("mail.imap.ssl.socketFactory", sf);

        return mailSender;

    }
}
