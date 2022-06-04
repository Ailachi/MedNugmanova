package kz.iitu.itse1909r.nugmanova.Controller;

import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import kz.iitu.itse1909r.nugmanova.JMS.JmsMessage;
import kz.iitu.itse1909r.nugmanova.JMS.JmsMessageListener;
import kz.iitu.itse1909r.nugmanova.JMS.JmsMessageSender;
import kz.iitu.itse1909r.nugmanova.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/docs")
public class DoctorController {
    MessageSource source = null;
    DoctorService service = null;
    JmsMessageSender jmsService = null;

    @Autowired
    public DoctorController(DoctorService doctorService, MessageSource msg, JmsMessageSender jms) {
        service = doctorService;
        source = msg;
        jmsService = jms;
    }

    @GetMapping("/")
    public String index(Locale locale) {
        return source.getMessage("msg.doctor", null, locale);
    }

    @GetMapping("/emailpassword/{email}/{password}")
    public List<Doctor> findAllByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        return service.findAllByEmailAndPassword(email, password);
    }

    @GetMapping("/getallafterdate/{date}")
    public List<Doctor> getAllDoctorsWithAppointmentsAfter(@PathVariable String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dt = LocalDate.parse(date, formatter);
        return service.getAllDoctorsWithAppointmentsAfter(dt);
    }

    @GetMapping("/getbyspecialty/{specialtyId}")
    public List<Doctor> getAlLSpecializedDoctors(@PathVariable Integer specialtyId) {
        return service.getAlLSpecializedDoctors(specialtyId);
    }

    @PostMapping("/postmsg/{patientId}")
    public String sendMessage(@RequestBody String message, @PathVariable Integer patientId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JmsMessage jmsMessage = new JmsMessage();
        jmsMessage.setMessage(message);
        jmsMessage.setPatientId(patientId);
        jmsService.sendMessageToPatient(jmsMessage, auth.getName());

        return "The message from doctor is sent: " + message;
    }

    @GetMapping("/getmsg")
    public List<JmsMessage> getMessage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Doctor doctor = service.getDoctorByEmail(auth.getName());
        ArrayList<JmsMessage> msgs = JmsMessageListener.msgsToPatient;
        return msgs.stream().filter(p -> p.getDoctorId().equals(doctor.getDoctorId())).collect(Collectors.toList());
    }
}
