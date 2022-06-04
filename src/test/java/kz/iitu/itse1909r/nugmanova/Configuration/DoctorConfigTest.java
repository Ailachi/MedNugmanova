package kz.iitu.itse1909r.nugmanova.Configuration;

import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import kz.iitu.itse1909r.nugmanova.Database.Specialty;
import kz.iitu.itse1909r.nugmanova.ElviraNugmanovaItse1909RApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import static org.mockito.Mockito.*;

class DoctorConfigTest {
    @Mock
    Environment environment;
    @InjectMocks
    DoctorConfig doctorConfig;
    @Mock
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDoctor() {
        Doctor result = doctorConfig.doctor();
//        context = SpringApplication.run(ElviraNugmanovaItse1909RApplication.class);
//        Doctor result = context.getBean(Doctor.class);
        Doctor dc = new Doctor("example@gmail.com", "qwerty", "Dolittle", "John");
        Specialty spec = new Specialty();
        spec.setSpecName("General Practitioner");
        dc.setSpecialty(spec);
        Assertions.assertNotNull(result);
    }

    @Test
    void testSpecialty() {
        Specialty result = doctorConfig.specialty();
        Assertions.assertEquals(new Specialty(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme