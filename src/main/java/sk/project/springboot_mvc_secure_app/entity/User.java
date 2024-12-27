package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

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

    public User(String name, String email, String passwordHash, String phoneNumber, String company, String jobTitle, Role role, LocalDate createdAt, Boolean isActive, LocalDate lastLogin, String profilePicture, String address, String gender, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.jobTitle = jobTitle;
        this.role = role;
        this.createdAt = LocalDate.now();
        this.isActive = isActive;
        this.lastLogin = LocalDate.now();
        this.profilePicture = profilePicture;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is required") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is required") String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(@NotBlank(message = "Password is required") String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public @Pattern(regexp = "^[+\\d]{1,3}[\\s\\d]*$", message = "Phone number should be valid") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Pattern(regexp = "^[+\\d]{1,3}[\\s\\d]*$", message = "Phone number should be valid") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User() {
        this.createdAt = LocalDate.now();
        this.isActive = true;
    }
}

