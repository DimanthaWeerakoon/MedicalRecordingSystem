package MedicalRecordingSystem.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String age;
    private String gender;
    private String mobile;
    private String city;
    private String role;

}
