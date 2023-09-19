package MedicalRecordingSystem.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String position;
    private String specializedArea;
    private boolean availability;
    private String photo;
    private double ratings;
    private String username;
    private String password;
    private String tasks;
    private String timeSlot;
    private String status;
    private String language;
    private String qualifications;
    private String reminders;

    public Doctor(String firstName, String lastName, String email, String username, String password, String mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public Doctor() {
    }

}
