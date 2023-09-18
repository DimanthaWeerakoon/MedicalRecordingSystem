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
public class Prescription {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String medicine;
    private String dosage;
    private String frequency;
    private String instructions;
    private String signature;
}
