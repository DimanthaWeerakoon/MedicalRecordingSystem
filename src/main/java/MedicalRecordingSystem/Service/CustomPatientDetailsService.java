package MedicalRecordingSystem.Service;

import MedicalRecordingSystem.Entities.Patient;
import MedicalRecordingSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomPatientDetailsService implements UserDetailsService {


    private final PatientRepository patientRepository;

    @Autowired
    public CustomPatientDetailsService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByUsername(username);
        if (patient == null){
            throw new UsernameNotFoundException("Patient not found with this Username!");
        }
        return new CustomPatientDetails(patient);
    }
}
