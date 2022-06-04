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

class MedicalRecordTest {
    @Mock
    List<Allergy> allergies;
    @Mock
    List<Appointment> appointments;
    @Mock
    Patient patient;
    @InjectMocks
    MedicalRecord medicalRecord;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetRecordId() {
        medicalRecord.setRecordId(Integer.valueOf(0));
    }

    @Test
    void testSetAllergies() {
        medicalRecord.setAllergies(Arrays.<Allergy>asList(new Allergy()));
    }

    @Test
    void testSetAppointments() {
        medicalRecord.setAppointments(Arrays.<Appointment>asList(new Appointment()));
    }

    @Test
    void testSetPatient() {
        medicalRecord.setPatient(new Patient());
    }

    @Test
    void testSetBloodType() {
        medicalRecord.setBloodType("bloodType");
    }

//    @Test
//    void testEquals() {
//        boolean result = medicalRecord.equals("o");
//        Assertions.assertNotNull(result);
//    }

//    @Test
//    void testCanEqual() {
//        boolean result = medicalRecord.canEqual("other");
//        Assertions.assertNotNull(result);
//    }

    @Test
    void testHashCode() {
        medicalRecord.setAllergies(null);
        medicalRecord.setAppointments(null);
        medicalRecord.setPatient(null);
        int result = medicalRecord.hashCode();
        Assertions.assertEquals(1, result);
    }

    @Test
    void testToString() {
        String result = medicalRecord.toString();
        Assertions.assertEquals("MedicalRecord(recordId=null, allergies=allergies, appointments=appointments, patient=patient, bloodType=null)", result);
    }
}

