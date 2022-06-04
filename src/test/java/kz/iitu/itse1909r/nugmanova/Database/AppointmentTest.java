package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.*;

class AppointmentTest {
    @Mock
    Patient patient;
    @Mock
    Doctor doctor;
    @Mock
    MedicalRecord record;
    @InjectMocks
    Appointment appointment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetAppointmentId() {
        appointment.setAppointmentId(Integer.valueOf(0));
    }

    @Test
    void testSetPatient() {
        appointment.setPatient(new Patient());
    }

    @Test
    void testSetDoctor() {
        appointment.setDoctor(new Doctor("email", "password", "surname", "name"));
    }

    @Test
    void testSetPrescription() {
        appointment.setPrescription("prescription");
    }

    @Test
    void testSetDiagnosis() {
        appointment.setDiagnosis("diagnosis");
    }

    @Test
    void testSetAppointDate() {
        appointment.setAppointDate(LocalDate.of(2022, Month.MAY, 13));
    }

    @Test
    void testSetRecord() {
        appointment.setRecord(new MedicalRecord());
    }

    @Test
    void testEquals() {
        boolean result = appointment.equals("o");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCanEqual() {
        boolean result = appointment.canEqual("other");
        Assertions.assertNotNull(result);
    }

    @Test
    void testHashCode() {
        appointment.setDoctor(null);
        appointment.setPatient(null);
        appointment.setDiagnosis("aaa");
        appointment.setPrescription("aaa");
        appointment.setRecord(null);
        int result = appointment.hashCode();
        Assertions.assertEquals(-1302008742, result);
    }

    @Test
    void testToString() {
        String result = appointment.toString();
        Assertions.assertEquals("APPOINTMENT INFO: null DOCTOR: null null, PATIENT: null null", result);
    }
}
