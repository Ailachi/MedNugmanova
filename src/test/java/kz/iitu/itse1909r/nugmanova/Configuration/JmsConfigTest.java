package kz.iitu.itse1909r.nugmanova.Configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;

class JmsConfigTest {
    JmsConfig jmsConfig = new JmsConfig();


    @Test
    void testJacksonJmsMessageConverter() {
        MessageConverter result = jmsConfig.jacksonJmsMessageConverter();
        Assertions.assertNotNull(result);
    }
}