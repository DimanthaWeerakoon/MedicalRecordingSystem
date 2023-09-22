package MedicalRecordingSystem.Controller;

import MedicalRecordingSystem.Model.PatientRequest;
import MedicalRecordingSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/registration")
public class PatientController {
    private final UserDetailsService userDetailsService;
    private final UserDetails userDetails;
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService, @Qualifier("customPatientDetailsService") UserDetailsService userDetailsService, UserDetails userDetails) {
        this.patientService = patientService;
        this.userDetailsService = userDetailsService;
        this.userDetails = userDetails;
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

    @GetMapping("/patient/login")
    public String login(){
        return "loginPatient";
    }

    @GetMapping("/patient-page")
    public String userPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "patient";
    }
}
