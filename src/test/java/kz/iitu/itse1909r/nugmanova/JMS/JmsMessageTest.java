package kz.iitu.itse1909r.nugmanova.JMS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JmsMessageTest {
    JmsMessage jmsMessage = new JmsMessage();

    @Test
    void testSetMessage() {
        jmsMessage.setMessage("message");
    }

    @Test
    void testSetDoctorId() {
        jmsMessage.setDoctorId(Integer.valueOf(0));
    }

    @Test
    void testSetPatientId() {
        jmsMessage.setPatientId(Integer.valueOf(0));
    }

    @Test
    void testEquals() {
        boolean result = jmsMessage.equals("o");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCanEqual() {
        boolean result = jmsMessage.canEqual("other");
        Assertions.assertNotNull(result);
    }

    @Test
    void testHashCode() {
        int result = jmsMessage.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = jmsMessage.toString();
        Assertions.assertEquals("JmsMessage(message=null, doctorId=null, patientId=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme