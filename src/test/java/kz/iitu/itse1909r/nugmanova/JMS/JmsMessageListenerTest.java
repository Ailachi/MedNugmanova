package kz.iitu.itse1909r.nugmanova.JMS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import javax.jms.TextMessage;
import java.util.Queue;

import static org.mockito.Mockito.*;

class JmsMessageListenerTest {
    @Mock
    Queue<String> queue;
    @Mock
    Logger logger;
    @InjectMocks
    JmsMessageListener jmsMessageListener;
    @Mock
    JmsMessage jms;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testOnPatientMessage() {
        jms.setMessage("aaa");
        jmsMessageListener.onPatientMessage(jms);
    }

    @Test
    void testOnDoctorMessage() {
        jmsMessageListener.onDoctorMessage(new JmsMessage());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme