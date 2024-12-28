package sk.project.springboot_mvc_secure_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserPasswordDTO {

    private Long id;

    private String passwordHash;

    @NotBlank(message = "Old password is required")
    private String oldPassword;

    @NotBlank(message = "New password is required")
    @Size(min = 6, message = "New password must be at least 6 characters long")
    private String newPassword;

    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public @NotBlank(message = "Old password is required") String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(@NotBlank(message = "Old password is required") String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public @NotBlank(message = "New password is required") @Size(min = 6, message = "New password must be at least 6 characters long") String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(@NotBlank(message = "New password is required") @Size(min = 6, message = "New password must be at least 6 characters long") String newPassword) {
        this.newPassword = newPassword;
    }

    public @NotBlank(message = "Confirm password is required") String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@NotBlank(message = "Confirm password is required") String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
