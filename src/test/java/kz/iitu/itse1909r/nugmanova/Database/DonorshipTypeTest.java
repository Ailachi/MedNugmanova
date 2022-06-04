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

class DonorshipTypeTest {
    @Mock
    Donor donor;
    @Mock
    List<WaitingList> waitingList;
    @InjectMocks
    DonorshipType donorshipType;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetDonorshipTypeId() {
        donorshipType.setDonorshipTypeId(Integer.valueOf(0));
    }

    @Test
    void testSetName() {
        donorshipType.setName("name");
    }

    @Test
    void testSetDonor() {
        donorshipType.setDonor(new Donor());
    }

    @Test
    void testSetWaitingList() {
        donorshipType.setWaitingList(Arrays.<WaitingList>asList(new WaitingList()));
    }

    @Test
    void testEquals() {
        boolean result = donorshipType.equals("o");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCanEqual() {
        boolean result = donorshipType.canEqual("other");
        Assertions.assertNotNull(result);
    }

    @Test
    void testHashCode() {
        int result = donorshipType.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = donorshipType.toString();
        Assertions.assertEquals("DonorshipType(donorshipTypeId=null, name=null, donor=donor, waitingList=waitingList)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme