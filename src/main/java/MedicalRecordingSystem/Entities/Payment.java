package MedicalRecordingSystem.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter
public class Payment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private double amount;
    private Date date;
    private Time time;
    private String method;
}
