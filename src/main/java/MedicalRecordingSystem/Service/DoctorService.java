package MedicalRecordingSystem.Service;

import MedicalRecordingSystem.Entities.Doctor;
import MedicalRecordingSystem.Model.DoctorRequest;

public interface DoctorService {
    Doctor save(DoctorRequest doctorRequest);
}
