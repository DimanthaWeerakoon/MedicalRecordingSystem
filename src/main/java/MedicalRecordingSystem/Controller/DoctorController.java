package MedicalRecordingSystem.Controller;

import MedicalRecordingSystem.Model.DoctorRequest;
import MedicalRecordingSystem.Service.DoctorService;
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
public class DoctorController {

    private final UserDetailsService userDetailsService;
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService, @Qualifier("customDoctorDetailService") UserDetailsService userDetailsService) {
        this.doctorService = doctorService;
        this.userDetailsService = userDetailsService;
    }

    @ModelAttribute("doctor")
    public DoctorRequest doctorRequest() {
        return new DoctorRequest();
    }

    @GetMapping("/doctor")
    public String showRegistrationForm() {
        return "registrationDoctor";
    }

    @PostMapping("/doctor")
    public String registerDoctorAccount(@ModelAttribute("doctor") DoctorRequest doctorRequest) {
        doctorService.save(doctorRequest);
        return "redirect:/registration/doctor?success";
    }

    @GetMapping("/doctor/login")
    public String login() {
        return "loginDoctor";
    }

    @GetMapping("/doctor-page")
    public String userPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "doctor";
    }

}
