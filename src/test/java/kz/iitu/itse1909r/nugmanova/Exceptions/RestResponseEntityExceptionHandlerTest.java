package kz.iitu.itse1909r.nugmanova.Exceptions;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

class RestResponseEntityExceptionHandlerTest {
    @Mock
    Log pageNotFoundLogger;
    @Mock
    Log logger;
    @InjectMocks
    RestResponseEntityExceptionHandler restResponseEntityExceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testHandleBadRequest() {
        ResponseEntity<Object> result = restResponseEntityExceptionHandler.handleBadRequest(null, null);
        Assertions.assertNotEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme