package kz.iitu.itse1909r.nugmanova.Controller;

import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import kz.iitu.itse1909r.nugmanova.JMS.JmsMessage;
import kz.iitu.itse1909r.nugmanova.JMS.JmsMessageSender;
import kz.iitu.itse1909r.nugmanova.Service.DoctorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class DoctorControllerTest {
    @Mock
    MessageSource source;
    @Mock
    DoctorService service;
    @Mock
    JmsMessageSender jmsService;
    @InjectMocks
    DoctorController doctorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testIndex() {
        String result = doctorController.index(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testFindAllByEmailAndPassword() {
        when(service.findAllByEmailAndPassword(anyString(), anyString())).thenReturn(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")));

        List<Doctor> result = doctorController.findAllByEmailAndPassword("email", "password");
        Assertions.assertEquals(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")), result);
    }

    @Test
    void testGetAllDoctorsWithAppointmentsAfter() {
        when(service.getAllDoctorsWithAppointmentsAfter(any())).thenReturn(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")));
        String date = "11-05-2022";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dt = LocalDate.parse(date, formatter);
        List<Doctor> result = doctorController.getAllDoctorsWithAppointmentsAfter(date);
        Assertions.assertEquals(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")), result);
    }

    @Test
    void testGetAlLSpecializedDoctors() {
        when(service.getAlLSpecializedDoctors(anyInt())).thenReturn(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")));

        List<Doctor> result = doctorController.getAlLSpecializedDoctors(Integer.valueOf(0));
        Assertions.assertEquals(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")), result);
    }

}