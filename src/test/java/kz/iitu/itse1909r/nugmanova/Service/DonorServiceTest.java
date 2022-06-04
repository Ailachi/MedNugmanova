package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Donor;
import kz.iitu.itse1909r.nugmanova.Repository.DonorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class DonorServiceTest {
    @Mock
    DonorRepository repo;
    @InjectMocks
    DonorService donorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllDonors() {
        List<Donor> result = donorService.getAllDonors();
        Assertions.assertEquals(new ArrayList<>(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme