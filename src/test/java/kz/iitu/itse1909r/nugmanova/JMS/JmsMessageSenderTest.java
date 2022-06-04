package kz.iitu.itse1909r.nugmanova.JMS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.Mockito.*;

class JmsMessageSenderTest {
    @Mock
    Logger logger;
    @Mock
    JmsTemplate jmsTemplate;
    @InjectMocks
    JmsMessageSender jmsMessageSender;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void testSendMessageToPatient() {
//        jmsMessageSender.sendMessageToPatient(new JmsMessage(), anyString());
//    }
//
//    @Test
//    void testSendMessageToDoctor() {
//        jmsMessageSender.sendMessageToDoctor(new JmsMessage(), anyString());
//    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme