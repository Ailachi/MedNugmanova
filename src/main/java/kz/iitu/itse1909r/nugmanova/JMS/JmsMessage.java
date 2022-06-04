package kz.iitu.itse1909r.nugmanova.JMS;

import lombok.Data;

@Data
public class JmsMessage {
    private String message;
    private Integer doctorId;
    private Integer patientId;
}
