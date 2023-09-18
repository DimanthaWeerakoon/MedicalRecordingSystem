package MedicalRecordingSystem.Service;

import MedicalRecordingSystem.Entities.Patient;
import MedicalRecordingSystem.Model.PatientRequest;

public interface PatientService {

    Patient save(PatientRequest patientRequest);
}
