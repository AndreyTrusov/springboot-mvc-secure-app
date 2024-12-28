package sk.project.springboot_mvc_secure_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

        manager.setUsersByUsernameQuery(
                "SELECT email AS username, password_hash AS password, is_active AS enabled " +
                        "FROM user WHERE email = ?"
        );

        manager.setAuthoritiesByUsernameQuery(
                "SELECT u.email AS username, r.role_name AS authority " +
                        "FROM user u " +
                        "JOIN role r ON u.role_id = r.role_id " +
                        "WHERE u.email = ?"
        );

        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().ignoringRequestMatchers("/register");
        http.csrf().ignoringRequestMatchers("/user");

        http.authorizeHttpRequests(configurer -> configurer
                                .requestMatchers("/events/**", "/register/**").permitAll()
                                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN", "CREATOR")
                                .requestMatchers("/register/**").hasAnyRole("USER", "ADMIN", "CREATOR")
                                .requestMatchers("/events/**").hasAnyRole("USER", "ADMIN", "CREATOR")
                                .requestMatchers("/error/**").hasAnyRole("USER", "ADMIN", "CREATOR")
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticate")
                        .defaultSuccessUrl("/events")
                        .failureUrl("/login?error=true")
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