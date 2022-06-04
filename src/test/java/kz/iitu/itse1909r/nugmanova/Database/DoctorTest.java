package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class DoctorTest {
    @Mock
    Logger log;
    @Mock
    Specialty specialty;
    @Mock
    List<Appointment> appointments;
    @InjectMocks
    Doctor doctor;
    Doctor dc = new Doctor();
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDestroySession() {
        doctor.destroySession();
    }

    @Test
    void testToString() {
        String result = doctor.toString();
        Assertions.assertEquals("DOCTOR INFO: null null, null null, null", result);
    }

    @Test
    void testSetLog() {
        doctor.setLog(null);
    }

    @Test
    void testSetDoctorId() {
        doctor.setDoctorId(Integer.valueOf(0));
    }

    @Test
    void testSetEmail() {
        doctor.setEmail("email");
    }

    @Test
    void testSetPassword() {
        doctor.setPassword("password");
    }

    @Test
    void testSetSurname() {
        doctor.setSurname("surname");
    }

    @Test
    void testSetName() {
        doctor.setName("name");
    }

    @Test
    void testSetSpecialty() {
        doctor.setSpecialty(new Specialty());
    }

    @Test
    void testSetAppointments() {
        doctor.setAppointments(Arrays.<Appointment>asList(new Appointment()));
    }

    @Test
    void testEquals() {
        boolean result = doctor.equals("o");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCanEqual() {
        boolean result = doctor.canEqual("other");
        Assertions.assertNotNull(result);
    }

    @Test
    void testHashCode() {
        doctor.setAppointments(null);
        int result = doctor.hashCode();
        Assertions.assertEquals(64204658, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme