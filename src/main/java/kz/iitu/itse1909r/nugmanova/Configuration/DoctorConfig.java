package kz.iitu.itse1909r.nugmanova.Configuration;

import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import kz.iitu.itse1909r.nugmanova.Database.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@Profile(value = "dev")
@PropertySource(value = "classpath:doctor.properties")
public class DoctorConfig {

    Environment environment = null;

    @Autowired
    public DoctorConfig(Environment environment) {
        this.environment = environment;
    }


    @Bean(initMethod = "initSession", destroyMethod = "destroySession")
    @DependsOn(value="specialty")
    Doctor doctor() {
        Doctor doctor = new Doctor();
        doctor.setName(environment.getProperty("doctor.name"));
        doctor.setSurname(environment.getProperty("doctor.surname"));
        doctor.setEmail(environment.getProperty("doctor.email"));
        doctor.setPassword(environment.getProperty("doctor.password"));
        doctor.setSpecialty(specialty());
        return doctor;
    }

    @Bean("specialty")
    Specialty specialty() {
        Specialty specialty = new Specialty();
        specialty.setSpecName(environment.getProperty("doctor.specialty"));
        return specialty;
    }

}
