package MedicalRecordingSystem.Config;

import MedicalRecordingSystem.Service.CustomPatientDetailsService;
import MedicalRecordingSystem.Service.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    CustomSuccessHandler customSuccessHandler;

    CustomPatientDetailsService customPatientDetailsService;

    @Autowired
    public SecurityConfiguration(@Lazy CustomSuccessHandler customSuccessHandler, CustomPatientDetailsService customPatientDetailsService) {
        this.customSuccessHandler = customSuccessHandler;
        this.customPatientDetailsService = customPatientDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomSuccessHandler customSuccessHandler() {
        return new CustomSuccessHandler();
    }

    @Bean
    public UserDetails userDetails() {
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public String getUsername() {
                return null;
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(c -> c.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/registration/doctor/doctor-page").hasAnyAuthority("Doctor")
                        .requestMatchers("/registration/patient/patient-page").hasAnyAuthority("Patient")
                        .requestMatchers("/registration/patient", "/css/**").permitAll()
                        .requestMatchers("/registration/doctor", "/css/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/registration/patient/login")
                        .loginProcessingUrl("/registration/patient/login")
                        .successHandler(customSuccessHandler)
                        .permitAll())
                .formLogin(form -> form
                        .loginPage("/registration/doctor/login")
                        .loginProcessingUrl("/registration/patient/login")
                        .successHandler(customSuccessHandler)
                        .permitAll())

                .logout(form -> form
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/registration/patient/login?logout")
                        .permitAll())
                .logout(form -> form
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/registration/doctor/login?logout")
                        .permitAll());
        return http.build();


    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customPatientDetailsService).passwordEncoder(passwordEncoder());
    }

}
