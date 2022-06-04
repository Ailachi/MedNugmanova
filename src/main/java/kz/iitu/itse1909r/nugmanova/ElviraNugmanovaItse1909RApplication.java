package kz.iitu.itse1909r.nugmanova;


import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
public class ElviraNugmanovaItse1909RApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ElviraNugmanovaItse1909RApplication.class, args);
        Doctor dc = context.getBean(Doctor.class);
        System.out.println(dc);
    }
}
