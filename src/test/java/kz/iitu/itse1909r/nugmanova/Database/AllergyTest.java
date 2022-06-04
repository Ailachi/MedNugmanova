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

class AllergyTest {
    @Mock
    List<MedicalRecord> records;
    @InjectMocks
    Allergy allergy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetAllergyId() {
        allergy.setAllergyId(Integer.valueOf(0));
    }

    @Test
    void testSetName() {
        allergy.setName("name");
    }

    @Test
    void testSetRecords() {
        allergy.setRecords(Arrays.<MedicalRecord>asList(new MedicalRecord()));
    }

    @Test
    void testEquals() {
        boolean result = allergy.equals("o");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCanEqual() {
        boolean result = allergy.canEqual("other");
        Assertions.assertNotNull(result);
    }

    @Test
    void testHashCode() {
        allergy.setName("aaa");
        allergy.setRecords(null);
        int result = allergy.hashCode();
        Assertions.assertEquals(6038044, result);
    }

    @Test
    void testToString() {
        String result = allergy.toString();
        Assertions.assertEquals("Allergy(allergyId=null, name=null, records=records)", result);
    }
}

