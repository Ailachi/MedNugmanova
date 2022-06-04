package kz.iitu.itse1909r.nugmanova.Controller;

import kz.iitu.itse1909r.nugmanova.Database.Patient;
import kz.iitu.itse1909r.nugmanova.JMS.JmsMessage;
import kz.iitu.itse1909r.nugmanova.JMS.JmsMessageSender;
import kz.iitu.itse1909r.nugmanova.Service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class PatientControllerTest {
    @Mock
    MessageSource source;
    @Mock
    PatientService service;
    @Mock
    JmsMessageSender jmsService;
    @InjectMocks
    PatientController patientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testIndex() {
        String result = patientController.index(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetAllPatients() {
        when(service.getAllPatients()).thenReturn(Arrays.<Patient>asList(new Patient()));

        List<Patient> result = patientController.getAllPatients();
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetAllPatientsWithAllergy() {
        when(service.getAllPatientsWithAllergy(anyInt())).thenReturn(Arrays.<Patient>asList(new Patient()));

        List<Patient> result = patientController.getAllPatientsWithAllergy(Integer.valueOf(0));
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetAllByWaitingList() {
        when(service.getAllByWaitingList()).thenReturn(Arrays.<Patient>asList(new Patient()));

        List<Patient> result = patientController.getAllByWaitingList();
        Assertions.assertNotNull(result);
    }
}