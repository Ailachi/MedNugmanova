package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class WaitingListTest {
    @Mock
    Patient patient;
    @Mock
    Donor donor;
    @Mock
    DonorshipType type;
    @InjectMocks
    WaitingList waitingList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetWaitingListId() {
        waitingList.setWaitingListId(Integer.valueOf(0));
    }

    @Test
    void testSetPatient() {
        waitingList.setPatient(new Patient());
    }

    @Test
    void testSetDonor() {
        waitingList.setDonor(new Donor());
    }

    @Test
    void testSetType() {
        waitingList.setType(new DonorshipType());
    }

    @Test
    void testEquals() {
        boolean result = waitingList.equals("o");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCanEqual() {
        boolean result = waitingList.canEqual("other");
        Assertions.assertNotNull(result);
    }

    @Test
    void testHashCode() {
        waitingList.setDonor(null);
        waitingList.setType(null);
        waitingList.setPatient(null);
        int result = waitingList.hashCode();
        Assertions.assertEquals(21100921, result);
    }

    @Test
    void testToString() {
        String result = waitingList.toString();
        Assertions.assertEquals("WaitingList(waitingListId=null, patient=patient, donor=donor, type=type)", result);
    }
}
