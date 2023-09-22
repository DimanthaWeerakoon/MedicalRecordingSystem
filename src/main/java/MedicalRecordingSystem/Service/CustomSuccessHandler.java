package MedicalRecordingSystem.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var authorities = authentication.getAuthorities();
        var roles = authorities.stream().map(r -> r.getAuthority()).findFirst();
        if (roles.orElse("").equals("Doctor")) {
            response.sendRedirect("/registration/doctor-page");
        } else if (roles.orElse("").equals("Patient")) {
            response.sendRedirect("/registration/patient-page");

        } else {
            response.sendRedirect("/error");
        }
    }
}

