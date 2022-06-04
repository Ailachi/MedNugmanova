package kz.iitu.itse1909r.nugmanova.Exceptions;

import kz.iitu.itse1909r.nugmanova.AOP.LogErrorEntry;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class })
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("bad request", "400");
        body.put("message", "BAD REQUEST SPOTTED ON");
        return handleExceptionInternal(ex, body, httpHeaders, HttpStatus.BAD_REQUEST, request);
    }
}