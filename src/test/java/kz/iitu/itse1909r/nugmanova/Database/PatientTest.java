package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class PatientTest {
    @Mock
    List<Appointment> appointments;
    @Mock
    List<WaitingList> waitingList;
    @Mock
    MedicalRecord record;
    @InjectMocks
    Patient patient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        when(record.getBloodType()).thenReturn("getBloodTypeResponse");

        String result = patient.toString();
        Assertions.assertEquals("PATIENT INFO: null null, null null", result);
    }

    @Test
    void testSetPatientId() {
        patient.setPatientId(Integer.valueOf(0));
    }

    @Test
    void testSetEmail() {
        patient.setEmail("email");
    }

    @Test
    void testSetPassword() {
        patient.setPassword("password");
    }

    @Test
    void testSetName() {
        patient.setName("name");
    }

    @Test
    void testSetSurname() {
        patient.setSurname("surname");
    }

    @Test
    void testSetAppointments() {
        patient.setAppointments(Arrays.<Appointment>asList(new Appointment()));
    }

    @Test
    void testSetWaitingList() {
        patient.setWaitingList(Arrays.<WaitingList>asList(new WaitingList()));
    }

    @Test
    void testSetRecord() {
        patient.setRecord(new MedicalRecord());
    }

    @Test
    void testEquals() {
        boolean result = patient.equals("o");
        Assertions.assertNotNull(result);
    }

//    @Test
//    void testCanEqual() {
//        boolean result = patient.canEqual("other");
//        Assertions.assertNotNull(result);
//    }

    @Test
    void testHashCode() {
        patient.setRecord(null);
        patient.setAppointments(null);
        patient.setWaitingList(null);
        int result = patient.hashCode();
        Assertions.assertEquals(1, result);
    }
}

