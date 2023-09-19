package MedicalRecordingSystem.Service;

import MedicalRecordingSystem.Entities.Patient;
import MedicalRecordingSystem.Model.PatientRequest;
import MedicalRecordingSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(PatientRequest patientRequest) {
        Patient patient = new Patient(patientRequest.getFirstName(), patientRequest.getLastName(), patientRequest.getEmail(), patientRequest.getUsername(), patientRequest.getPassword(), patientRequest.getAge(), patientRequest.getGender(), patientRequest.getMobile(), patientRequest.getCity());
        return patientRepository.save(patient);
    }
}
