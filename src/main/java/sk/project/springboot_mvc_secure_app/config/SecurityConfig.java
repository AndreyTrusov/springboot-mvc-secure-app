package sk.project.springboot_mvc_secure_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import sk.project.springboot_mvc_secure_app.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager();
    }


    @Bean
    public InMemoryUserDetailsManager preConfiguredUserDetailsManager(UserServiceImpl userServiceImpl) {

//        List<UserDetails> users = userServiceImpl.findAllActiveUsers();

        List<UserDetails> users = new ArrayList<>();

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test")
                .roles("USER")
                .build();

        users.add(john);

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().ignoringRequestMatchers("/register");

        http.authorizeHttpRequests(configurer -> configurer
                                        .requestMatchers("/events/**", "/register/**").permitAll()
//                                        .requestMatchers("/", "/events", "/register", "/css/**", "/js/**", "/images/**").permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
                                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                                        .requestMatchers("/register/**").hasAnyRole("USER", "ADMIN")
                                        .requestMatchers("/events/**").hasAnyRole("USER", "ADMIN")
                                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticate")
//                        .defaultSuccessUrl("/events")
//                        .failureUrl("/login?error=true")
                                .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )
                .exceptionHandling(handling -> handling
                        .accessDeniedPage("/access-denied")
                );

        return http.build();
    }
}