package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Admin;
import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import kz.iitu.itse1909r.nugmanova.Database.Patient;
import kz.iitu.itse1909r.nugmanova.Repository.AdminRepository;
import kz.iitu.itse1909r.nugmanova.Repository.DoctorRepository;
import kz.iitu.itse1909r.nugmanova.Repository.DonorRepository;
import kz.iitu.itse1909r.nugmanova.Repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.Mockito.*;

class UserDetailsServiceImplTest {
    @Mock
    DoctorRepository doctorRepository;
    @Mock
    AdminRepository adminRepository;
    @Mock
    PatientRepository patientRepository;
    @Mock
    DonorRepository donorRepository;
    @InjectMocks
    UserDetailsServiceImpl userDetailsServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testLoadUserByUsername() {
        when(doctorRepository.findDoctorByEmail(anyString())).thenReturn(new Doctor("email", "password", null, null));
        when(adminRepository.getAdminByEmail(anyString())).thenReturn(new Admin("email", "password"));
        when(patientRepository.getPatientByEmail(anyString())).thenReturn(new Patient());

        UserDetails result = userDetailsServiceImpl.loadUserByUsername("username");
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetUserDetails() {
        UserDetails result = userDetailsServiceImpl.getUserDetails("email", "password", "role");
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme