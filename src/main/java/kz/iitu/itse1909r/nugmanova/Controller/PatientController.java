package kz.iitu.itse1909r.nugmanova.Controller;

import kz.iitu.itse1909r.nugmanova.Database.Patient;
import kz.iitu.itse1909r.nugmanova.JMS.JmsMessage;
import kz.iitu.itse1909r.nugmanova.JMS.JmsMessageListener;
import kz.iitu.itse1909r.nugmanova.JMS.JmsMessageSender;
import kz.iitu.itse1909r.nugmanova.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
public class PatientController {
    MessageSource source = null;
    PatientService service = null;
    JmsMessageSender jmsService = null;

    @Autowired
    public PatientController(PatientService patientService, MessageSource msg, JmsMessageSender jms) {
        service = patientService;
        source = msg;
        jmsService = jms;
    }

    @GetMapping("/")
    public String index(Locale locale) {
        return source.getMessage("msg.patient", null, locale);
    }

    @GetMapping("all")
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }

    @GetMapping("allergy/{allergyId}")
    public List<Patient> getAllPatientsWithAllergy(@PathVariable Integer allergyId) {
        return service.getAllPatientsWithAllergy(allergyId);
    }

    @GetMapping("waiting")
    public List<Patient> getAllByWaitingList() {
        return service.getAllByWaitingList();
    }

    @PostMapping("/postmsg/{doctorId}")
    public String sendMessage(@RequestBody String message, @PathVariable Integer doctorId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JmsMessage jmsMessage = new JmsMessage();
        jmsMessage.setMessage(message);
        jmsMessage.setDoctorId(doctorId);
        jmsService.sendMessageToDoctor(jmsMessage, auth.getName());
        return "The message from patient is sent: " + message;
    }

    @GetMapping("/getmsg")
    public List<JmsMessage> getMessage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Patient patient = service.getPatientByEmail(auth.getName());
        ArrayList<JmsMessage> msgs = JmsMessageListener.msgsToPatient;
        return msgs.stream().filter(p -> p.getPatientId().equals(patient.getPatientId())).collect(Collectors.toList());
    }
}
