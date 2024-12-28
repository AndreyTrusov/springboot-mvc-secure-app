package sk.project.springboot_mvc_secure_app.dto;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserProfileDTO {

    private Long id;

    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    private String phoneNumber;

    private String company;

    private String jobTitle;

    private LocalDate lastLogin;

    private String address;

    private String gender;

    private LocalDate dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String getName() {
        return name;
    }

    public void setName(@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
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
}
