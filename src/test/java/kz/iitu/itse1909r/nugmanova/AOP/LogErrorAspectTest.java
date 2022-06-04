package kz.iitu.itse1909r.nugmanova.AOP;

import kz.iitu.itse1909r.nugmanova.Repository.ErrorLogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import static org.mockito.Mockito.*;

class LogErrorAspectTest {
    @Mock
    ErrorLogRepository logRepo;
    @Mock
    Environment environment;
    @InjectMocks
    LogErrorAspect logErrorAspect;
    @Mock
    ProceedingJoinPoint proceedingJoinPoint;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAuthorizationAnnotatedMethods() {
        logErrorAspect.authorizationAnnotatedMethods();
    }

    @Test
    void testAllServiceClasses() {
        logErrorAspect.allServiceClasses();
    }

//    @Test
//    void testAuthorize() {
//        Object result = logErrorAspect.authorize(proceedingJoinPoint);
//        Assertions.assertEquals("replaceMeWithExpectedResult", result);
//    }
}

