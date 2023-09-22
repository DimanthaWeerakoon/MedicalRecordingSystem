package MedicalRecordingSystem;

import MedicalRecordingSystem.Config.SecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SecurityConfiguration.class)
public class MedicalRecordingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalRecordingSystemApplication.class, args);
    }

}
