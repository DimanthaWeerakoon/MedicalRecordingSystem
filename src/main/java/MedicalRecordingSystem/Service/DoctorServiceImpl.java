package MedicalRecordingSystem.Service;

import MedicalRecordingSystem.Entities.Doctor;
import MedicalRecordingSystem.Model.DoctorRequest;
import MedicalRecordingSystem.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor save(DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor(doctorRequest.getFirstName(), doctorRequest.getLastName(), doctorRequest.getEmail(), doctorRequest.getUsername(), doctorRequest.getPassword(), doctorRequest.getMobile());
        return doctorRepository.save(doctor);
    }
}
