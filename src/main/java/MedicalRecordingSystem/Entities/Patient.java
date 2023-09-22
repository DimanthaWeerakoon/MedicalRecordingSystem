package MedicalRecordingSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "patient")
public class Patient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int userid;

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String age;
    private String gender;
    private String mobile;
    private String city;
    private String userPhoto;
    private String records;
    private String role;


    public Patient(String firstName, String lastName, String email, String username, String password, String age, String gender, String mobile, String city, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.mobile = mobile;
        this.city = city;
        this.role= role;
    }


    public Patient() {

    }
}
