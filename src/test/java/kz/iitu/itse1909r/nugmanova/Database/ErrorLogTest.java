package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

class ErrorLogTest {
    //Field time of type LocalDateTime - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    ErrorLog errorLog = new ErrorLog();

    @Test
    void testSetErrorLogId() {
        errorLog.setErrorLogId(Integer.valueOf(0));
    }

    @Test
    void testSetOrigin() {
        errorLog.setOrigin("origin");
    }

    @Test
    void testSetStackTrace() {
        errorLog.setStackTrace("stackTrace");
    }

    @Test
    void testSetTime() {
        errorLog.setTime(LocalDateTime.of(2022, Month.MAY, 18, 1, 49, 11));
    }

    @Test
    void testEquals() {
        boolean result = errorLog.equals("o");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCanEqual() {
        boolean result = errorLog.canEqual("other");
        Assertions.assertNotNull(result);
    }

    @Test
    void testHashCode() {
        int result = errorLog.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = errorLog.toString();
        Assertions.assertEquals("ErrorLog(errorLogId=null, origin=null, stackTrace=null, time=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme