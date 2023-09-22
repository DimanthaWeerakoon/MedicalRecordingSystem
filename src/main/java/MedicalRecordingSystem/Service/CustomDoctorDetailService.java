package MedicalRecordingSystem.Service;

import MedicalRecordingSystem.Entities.Doctor;
import MedicalRecordingSystem.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomDoctorDetailService implements UserDetailsService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public CustomDoctorDetailService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByUsername(username);
        if (doctor == null){
            throw new UsernameNotFoundException("Doctor not found with this Username!");
        }
        return new CustomDoctorDetails(doctor);
    }
}
