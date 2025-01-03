package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @NotBlank(message = "Role name is required")
    @Size(min = 2, max = 50, message = "Role name must be between 2 and 50 characters")
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @Column(name = "description")
    private String description;


    public Role() {
        this.createdAt = LocalDate.now();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public @NotBlank(message = "Role name is required") @Size(min = 2, max = 50, message = "Role name must be between 2 and 50 characters") String getRoleName() {
        return roleName;
    }

    public void setRoleName(@NotBlank(message = "Role name is required") @Size(min = 2, max = 50, message = "Role name must be between 2 and 50 characters") String roleName) {
        this.roleName = roleName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

