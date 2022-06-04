package kz.iitu.itse1909r.nugmanova.AOP;

import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class LoggingAspectTest {
    @Mock
    Logger log;
    @InjectMocks
    LoggingAspect loggingAspect;
    @Mock
    JoinPoint joinPoint;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testServiceAndRepositoryMethods() {
        loggingAspect.serviceAndRepositoryMethods();
    }

    @Test
    void testLogAfterThrowing() {
        loggingAspect.logAfterThrowing(joinPoint, null);
    }

    @Test
    void testLogBefore() throws Throwable {
        loggingAspect.logBefore(joinPoint);
    }

    @Test
    void testLogAfter() throws Throwable {
        loggingAspect.logAfter(joinPoint);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme