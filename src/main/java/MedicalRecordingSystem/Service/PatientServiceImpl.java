package MedicalRecordingSystem.Service;

import MedicalRecordingSystem.Entities.Patient;
import MedicalRecordingSystem.Model.PatientRequest;
import MedicalRecordingSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, PasswordEncoder passwordEncoder) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Patient save(PatientRequest patientRequest) {
        Patient patient = new Patient(patientRequest.getFirstName(), patientRequest.getLastName(), patientRequest.getEmail(), patientRequest.getUsername(), passwordEncoder.encode(patientRequest.getPassword()), patientRequest.getAge(), patientRequest.getGender(), patientRequest.getMobile(), patientRequest.getCity(), patientRequest.getRole());
        return patientRepository.save(patient);
    }
}
