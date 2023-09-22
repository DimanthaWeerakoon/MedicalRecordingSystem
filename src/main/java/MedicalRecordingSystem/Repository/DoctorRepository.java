package MedicalRecordingSystem.Repository;

import MedicalRecordingSystem.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUsername (String username);
}
