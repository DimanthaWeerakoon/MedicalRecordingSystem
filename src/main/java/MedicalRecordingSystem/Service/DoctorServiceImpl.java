package MedicalRecordingSystem.Service;

import MedicalRecordingSystem.Entities.Doctor;
import MedicalRecordingSystem.Model.DoctorRequest;
import MedicalRecordingSystem.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final PasswordEncoder passwordEncoder;
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Doctor save(DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor(doctorRequest.getFirstName(), doctorRequest.getLastName(), doctorRequest.getEmail(), doctorRequest.getUsername(), passwordEncoder.encode(doctorRequest.getPassword()), doctorRequest.getMobile(), doctorRequest.getRole());
        return doctorRepository.save(doctor);
    }
}
