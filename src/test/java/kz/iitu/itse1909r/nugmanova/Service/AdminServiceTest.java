package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.*;
import kz.iitu.itse1909r.nugmanova.Repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AdminServiceTest {
    @Mock
    Logger log;
    @Mock
    AdminRepository repo;
    @Mock
    DonorRepository donorRepo;
    @Mock
    PatientRepository patientRepo;
    @Mock
    MedRepository medRepo;
    @Mock
    AppointmentRepository appRepo;
    @InjectMocks
    AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAdminByEmail() {
        when(repo.getAdminByEmail(anyString())).thenReturn(new Admin("email", "password"));

        Admin result = adminService.getAdminByEmail("email");
        Assertions.assertEquals(new Admin("email", "password"), result);
    }

    @Test
    void testDeletePatientByPatientId() {
        Integer result = adminService.deletePatientByPatientId(Integer.valueOf(0));
        Assertions.assertEquals(Integer.valueOf(1), result);
    }

//    @Test
//    void testAddPatient() {
//        Patient p = new Patient();
//        ReflectionTestUtils.setField(p,"name", "elvira");
//        Integer result = adminService.addPatient(p);
//        Assertions.assertNull(result);
//    }

    @Test
    void testEditPatient() {
        Integer result = adminService.editPatient(new Patient(), Integer.valueOf(0));
        Assertions.assertEquals(Integer.valueOf(0), result);
    }

    @Test
    void testGetPatientByEmailAndPassword() {
        when(patientRepo.getPatientByEmailAndPassword(anyString(), anyString())).thenReturn(new Patient());

        Patient result = adminService.getPatientByEmailAndPassword("email", "password");
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetAllDonorsByBloodType() {
        when(donorRepo.getAllByBloodType(anyString())).thenReturn(Arrays.<Donor>asList(new Donor()));

        List<Donor> result = adminService.getAllDonorsByBloodType("A+");
        Assertions.assertEquals(Arrays.<Donor>asList(new Donor()), result);
    }

    @Test
    void testAssignDonorsToWaitingList() {
        when(donorRepo.updateWaitingListEntriesWithDonors(anyInt(), anyInt())).thenReturn(Arrays.<Integer>asList(Integer.valueOf(0)));
        when(medRepo.getAllPatientsWithoutDonors()).thenReturn(Arrays.<MedicalRecord>asList(new MedicalRecord()));

        adminService.assignDonorsToWaitingList();
    }

    @Test
    void testCheckNextAppointment() {
        when(appRepo.checkNextAppointment()).thenReturn(new Appointment());

        Appointment result = adminService.checkNextAppointment();
        Assertions.assertEquals(new Appointment(), result);
    }
}