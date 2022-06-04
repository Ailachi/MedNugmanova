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

class DonorTest {
    @Mock
    DonorshipType type;
    @Mock
    List<WaitingList> waitingList;
    @InjectMocks
    Donor donor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetDonorId() {
        donor.setDonorId(Integer.valueOf(0));
    }

    @Test
    void testSetSurname() {
        donor.setSurname("surname");
    }

    @Test
    void testSetName() {
        donor.setName("name");
    }

    @Test
    void testSetBloodType() {
        donor.setBloodType("bloodType");
    }

    @Test
    void testSetType() {
        donor.setType(new DonorshipType());
    }

    @Test
    void testSetWaitingList() {
        donor.setWaitingList(Arrays.<WaitingList>asList(new WaitingList()));
    }

    @Test
    void testEquals() {
        boolean result = donor.equals("o");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCanEqual() {
        boolean result = donor.canEqual("other");
        Assertions.assertNotNull(result);
    }

    @Test
    void testHashCode() {
        int result = donor.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = donor.toString();
        Assertions.assertEquals("Donor(donorId=null, surname=null, name=null, bloodType=null, type=type, waitingList=waitingList, createdDate=null, createdBy=null)", result);
    }
}
