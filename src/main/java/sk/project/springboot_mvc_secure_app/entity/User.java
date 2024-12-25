package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(name = "Name")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(name = "Email", unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    @Column(name = "PasswordHash")
    private String passwordHash;

    @Pattern(regexp = "^[+\\d]{1,3}[\\s\\d]*$", message = "Phone number should be valid")
    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Company")
    private String company;

    @Column(name = "JobTitle")
    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
    private Role role;

    @Column(name = "CreatedAt", updatable = false)
    private LocalDate createdAt;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "LastLogin")
    private LocalDate lastLogin;

    @Column(name = "ProfilePicture")
    private String profilePicture;

    @Column(name = "Address")
    private String address;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "DateOfBirth")
    private LocalDate dateOfBirth;

    public User() {
        this.createdAt = LocalDate.now();
        this.isActive = true;
    }

}

