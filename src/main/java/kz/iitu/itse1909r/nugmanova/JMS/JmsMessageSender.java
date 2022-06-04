package kz.iitu.itse1909r.nugmanova.JMS;

import kz.iitu.itse1909r.nugmanova.Database.Doctor;
import kz.iitu.itse1909r.nugmanova.Database.Patient;
import kz.iitu.itse1909r.nugmanova.Repository.DoctorRepository;
import kz.iitu.itse1909r.nugmanova.Repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component("messageSender")
public class JmsMessageSender{
    private static final Logger logger = LoggerFactory.getLogger(JmsMessageSender.class);
    private JmsTemplate jmsTemplate = null;
    private DoctorRepository drepo = null;
    PatientRepository prepo = null;

    @Autowired
    public JmsMessageSender(JmsTemplate jms, DoctorRepository dr, PatientRepository pr) {
        jmsTemplate = jms;
        drepo = dr;
        prepo = pr;
    }
    public void sendMessageToPatient(final JmsMessage message, String doctorEmail) {
        Doctor dc = drepo.findDoctorByEmail(doctorEmail);
        message.setDoctorId(dc.getDoctorId());
        jmsTemplate.convertAndSend("ToPatient", message);
    }

    public void sendMessageToDoctor(final JmsMessage message, String patientEmail) {
        Patient patient = prepo.getPatientByEmail(patientEmail);
        message.setPatientId(patient.getPatientId());
        jmsTemplate.convertAndSend("ToDoctor", message);
    }
}
