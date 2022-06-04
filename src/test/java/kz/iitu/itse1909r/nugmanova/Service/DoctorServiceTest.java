package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import kz.iitu.itse1909r.nugmanova.Repository.DoctorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class DoctorServiceTest {
    @Mock
    DoctorRepository repo;
    @InjectMocks
    DoctorService doctorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllDoctors() {
        List<Doctor> result = doctorService.getAllDoctors();
        result.add(new Doctor("email", "password", "surname", "name"));
        Assertions.assertEquals(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")), result);
    }

    @Test
    void testFindAllByEmailAndPassword() {
        when(repo.findAllByEmailAndPassword(anyString(), anyString())).thenReturn(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")));

        List<Doctor> result = doctorService.findAllByEmailAndPassword("email", "password");
        Assertions.assertEquals(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")), result);
    }

    @Test
    void testGetAllDoctorsWithAppointmentsAfter() {
        when(repo.getAllDoctorsWithAppointmentsAfter(any())).thenReturn(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")));

        List<Doctor> result = doctorService.getAllDoctorsWithAppointmentsAfter(LocalDate.of(2022, Month.MAY, 20));
        Assertions.assertEquals(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")), result);
    }

    @Test
    void testGetAlLSpecializedDoctors() {
        when(repo.getAlLSpecializedDoctors(anyInt())).thenReturn(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")));

        List<Doctor> result = doctorService.getAlLSpecializedDoctors(Integer.valueOf(0));
        Assertions.assertEquals(Arrays.<Doctor>asList(new Doctor("email", "password", "surname", "name")), result);
    }

    @Test
    void testGetDoctorByEmail() {
        when(repo.getDoctorByEmail(anyString())).thenReturn(new Doctor("email", "password", "surname", "name"));

        Doctor result = doctorService.getDoctorByEmail("email");
        Assertions.assertEquals(new Doctor("email", "password", "surname", "name"), result);
    }
}