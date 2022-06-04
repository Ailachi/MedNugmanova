package kz.iitu.itse1909r.nugmanova.Controller;

import kz.iitu.itse1909r.nugmanova.AOP.LogErrorEntry;
import kz.iitu.itse1909r.nugmanova.Database.Admin;
import kz.iitu.itse1909r.nugmanova.Database.Appointment;
import kz.iitu.itse1909r.nugmanova.Database.Donor;
import kz.iitu.itse1909r.nugmanova.Database.Patient;
import kz.iitu.itse1909r.nugmanova.Service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/admin")
public class AdminController {
    AdminService service = null;
    MessageSource source = null;
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AdminController(MessageSource messageSource, AdminService adminService) {
        source = messageSource;
        service = adminService;
    }

    @RequestMapping(method = RequestMethod.OPTIONS, value = "/options")
    public ResponseEntity<?> adminOptions() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.DELETE, HttpMethod.HEAD, HttpMethod.OPTIONS,
                        HttpMethod.POST, HttpMethod.PUT)
                .build();
    }

    @GetMapping("/")
    public String index(Locale locale) {
        return source.getMessage("msg.admin", null, locale);
    }

    @GetMapping("/donor/")
    public String indexDonor(Locale locale) {
        return source.getMessage("msg.donor", null, locale);
    }

    @DeleteMapping("/deletepatient/{patientId}")
    public String deletePatientByPatientId(@PathVariable Integer patientId) {
        Integer x = service.deletePatientByPatientId(patientId);
        if (x == 1) return "The patient has been successfully removed!";
        else return "There is no patient for such an ID";
    }

    @LogErrorEntry
    @PostMapping(value = "/add/patient", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addPatient(@RequestBody Patient patient) {
        Integer x = service.addPatient(patient);
        if (x == 1) return "The patient " + patient.getName() + " " + patient.getSurname() + " has been successfully added!";
        else return "An error has occurred.";
    }

    @PutMapping(value = "/edit/patient/{patientId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editPatient(@RequestBody Patient patient, @PathVariable Integer patientId) {
        Integer x = service.editPatient(patient, patientId);
        if (x == 1) return "The patient " + patient.getName() + " " + patient.getSurname() + " has been successfully edited!";
        else return "An error has occurred.";
    }

    @RequestMapping(value = "/getpatient/{email}/{password}", method = RequestMethod.HEAD, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPatientByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MY OWN HEADER", "HOORAY!");
        Patient pt = service.getPatientByEmailAndPassword(email, password);
        responseHeaders.set("Patient", pt.toString());
        return ResponseEntity.ok().headers(responseHeaders).body(pt.toString());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/getdonorsbyblood/{bloodType}")
    public List<Donor> getAllDonorsByBlood(@PathVariable String bloodType, @RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });
        return service.getAllDonorsByBloodType(bloodType);
    }

    @GetMapping(value = "/checknext")
    public Appointment checkNextAppointment() {
        Appointment app = service.checkNextAppointment();
        log.info("YOUR NEXT APPOINTMENT IS: " + app.toString());
        return app;
    }

    @GetMapping(value = "/getbyemail/{email}")
    public Admin getByEmail(@PathVariable String email) {
        return service.getAdminByEmail(email);
    }
}

