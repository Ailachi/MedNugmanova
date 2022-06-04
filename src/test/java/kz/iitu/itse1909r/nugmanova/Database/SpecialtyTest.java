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

class SpecialtyTest {
    @Mock
    List<Doctor> doctors;
    @InjectMocks
    Specialty specialty;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        String result = specialty.toString();
        Assertions.assertEquals("SPECIALTY INFO: null", result);
    }

    @Test
    void testSetSpecialtyId() {
        specialty.setSpecialtyId(Integer.valueOf(0));
    }

    @Test
    void testSetSpecName() {
        specialty.setSpecName("specName");
    }

    @Test
    void testSetDoctors() {
        specialty.setDoctors(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")));
    }

    @Test
    void testEquals() {
        boolean result = specialty.equals("o");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCanEqual() {
        boolean result = specialty.canEqual("other");
        Assertions.assertNotNull(result);
    }

    @Test
    void testHashCode() {
        specialty.setDoctors(null);
        int result = specialty.hashCode();
        Assertions.assertEquals(357642, result);
    }
}
