package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Patient;
import kz.iitu.itse1909r.nugmanova.Repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class PatientServiceTest {
    @Mock
    Logger log;
    @Mock
    PatientRepository repo;
    @InjectMocks
    PatientService patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllPatients() {
        List<Patient> result = patientService.getAllPatients();
        Assertions.assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testGetAllPatientsWithAllergy() {
        when(repo.getAllPatientsWithAllergy(anyInt())).thenReturn(Arrays.<Patient>asList(new Patient()));

        List<Patient> result = patientService.getAllPatientsWithAllergy(Integer.valueOf(0));
        Assertions.assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testGetAllByWaitingList() {
        when(repo.getAllByWaitingList()).thenReturn(Arrays.<Patient>asList(new Patient()));

        List<Patient> result = patientService.getAllByWaitingList();
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetPatientByEmail() {
        when(repo.getPatientByEmail(anyString())).thenReturn(new Patient());

        Patient result = patientService.getPatientByEmail("elvira@gmail.com");
        Assertions.assertEquals("PATIENT INFO: null null, null null", result.toString());
    }
}