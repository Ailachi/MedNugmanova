package kz.iitu.itse1909r.nugmanova.Controller;

import kz.iitu.itse1909r.nugmanova.Database.*;
import kz.iitu.itse1909r.nugmanova.Service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static org.mockito.Mockito.*;

class AdminControllerTest {
    @Mock
    AdminService service;
    @Mock
    MessageSource source;
    @Mock
    Logger log;
    @InjectMocks
    AdminController adminController;
    @Mock
    AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAdminOptions() {
        ResponseEntity<?> result = adminController.adminOptions();
        Assertions.assertNotEquals(null, result);
    }

    @Test
    void testIndex() {
        String result = adminController.index(new Locale("ES-es"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testIndexDonor() {
        String result = adminController.indexDonor(null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeletePatientByPatientId() {
        when(service.deletePatientByPatientId(anyInt())).thenReturn(Integer.valueOf(0));
        String result = adminController.deletePatientByPatientId(Integer.valueOf(0));
        Assertions.assertEquals("There is no patient for such an ID", result);
    }

    @Test
    void testAddPatient() {
        when(service.addPatient(any())).thenReturn(Integer.valueOf(0));

        String result = adminController.addPatient(new Patient());
        Assertions.assertEquals("An error has occurred.", result);
    }

    @Test
    void testEditPatient() {
        when(service.editPatient(any(), anyInt())).thenReturn(Integer.valueOf(0));

        String result = adminController.editPatient(new Patient(), Integer.valueOf(0));
        Assertions.assertEquals("An error has occurred.", result);
    }

    @Test
    void testGetPatientByEmailAndPassword() {
        when(service.getPatientByEmailAndPassword(anyString(), anyString())).thenReturn(new Patient());

        ResponseEntity<String> result = adminController.getPatientByEmailAndPassword("email", "password");
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetAllDonorsByBlood() {
        when(service.getAllDonorsByBloodType(anyString())).thenReturn(Arrays.<Donor>asList(new Donor()));

        List<Donor> result = adminController.getAllDonorsByBlood("bloodType", new HashMap<String, String>() {{
            put("String", "String");
        }});
        Assertions.assertEquals(Arrays.<Donor>asList(new Donor()), result);
    }

    @Test
    void testCheckNextAppointment() {
        Appointment app = new Appointment();
        app.setRecord(new MedicalRecord());
        app.setPatient(new Patient());
        app.setDoctor(new Doctor());
        when(service.checkNextAppointment()).thenReturn(app);

        Appointment result = adminController.checkNextAppointment();
        Assertions.assertEquals("APPOINTMENT INFO: null DOCTOR: null null, PATIENT: null null", result.toString());
    }

    @Test
    void testGetByEmail() {
        when(service.getAdminByEmail(anyString())).thenReturn(new Admin("email", "password"));

        Admin result = adminController.getByEmail("email");
        Assertions.assertEquals(new Admin("email", "password"), result);
    }
}