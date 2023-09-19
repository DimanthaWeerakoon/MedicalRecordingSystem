package MedicalRecordingSystem.Controller;

import MedicalRecordingSystem.Model.PatientRequest;
import MedicalRecordingSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ModelAttribute("patient")
    public PatientRequest patientRequest() {

        return new PatientRequest();
    }

    @GetMapping("/patient")
    public String showRegistrationForm() {

        return "registrationPatient";
    }

    @PostMapping("/patient")
    public String registerPatientAccount(@ModelAttribute("patient") PatientRequest patientRequest) {
        patientService.save(patientRequest);
        return "redirect:/registration/patient?success";
    }
}
