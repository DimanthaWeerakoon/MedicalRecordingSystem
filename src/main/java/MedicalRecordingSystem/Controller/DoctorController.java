package MedicalRecordingSystem.Controller;

import MedicalRecordingSystem.Model.DoctorRequest;
import MedicalRecordingSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @ModelAttribute("doctor")
    public DoctorRequest doctorRequest(){
        return new DoctorRequest();
    }

    @GetMapping("/doctor")
    public String showRegistrationForm(){
        return "registrationDoctor";
    }

    @PostMapping("/doctor")
    public String registerDoctorAccount(@ModelAttribute("doctor") DoctorRequest doctorRequest){
        doctorService.save(doctorRequest);
        return "redirect:/registrationDoctor?success";
    }

}
