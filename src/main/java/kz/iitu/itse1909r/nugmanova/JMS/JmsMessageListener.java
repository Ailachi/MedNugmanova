package kz.iitu.itse1909r.nugmanova.JMS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component("messageListener")
public class JmsMessageListener{

    public static ArrayList<JmsMessage> msgsToDoctor = new ArrayList();
    public static ArrayList<JmsMessage> msgsToPatient = new ArrayList();

    private static final Logger logger = LoggerFactory.getLogger(JmsMessageListener.class);

    @JmsListener(destination = "ToPatient", containerFactory = "jmsFactory")
    public void onPatientMessage(JmsMessage message) { // WHEN THE PATIENT GETS A MESSAGE FROM A DOCTOR
        msgsToPatient.add(message);
        logger.info("PATIENT GOT A MESSAGE!");
    }

    @JmsListener(destination = "ToDoctor", containerFactory = "jmsFactory")
    public void onDoctorMessage(JmsMessage message) { // WHEN THE DOCTOR GETS A MESSAGE FROM A PATIENT
        msgsToDoctor.add(message);
        logger.info("DOCTOR GOT A MESSAGE!");

    }
}