package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;


@Setter
@Getter
@Entity
@Table(name = "learning_center")
public class LearningCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LearningCenterId")
    private Long learningCenterId;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(name = "Name", nullable = false)
    private String name;

    @NotBlank(message = "Address is required")
    @Size(min = 10, max = 255, message = "Address must be between 10 and 255 characters")
    @Column(name = "Address", nullable = false)
    private String address;

    @Min(value = 1, message = "Capacity must be at least 1")
    @Column(name = "Capacity", nullable = false)
    private Integer capacity;

    @Pattern(regexp = "^\\+?[0-9]{10,20}$", message = "Phone number should be valid")
    @Column(name = "Phone")
    private String phone;

    @URL(message = "Webpage must be a valid URL")
    @Column(name = "Webpage")
    private String webpage;

    @Email(message = "Email should be valid")
    @Column(name = "Email")
    private String email;

    @PastOrPresent(message = "Established date cannot be in the future")
    @Column(name = "EstablishedDate")
    private LocalDate establishedDate;

    @Column(name = "CreatedAt", updatable = false)
    private LocalDate createdAt;

    public LearningCenter() {
        this.createdAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "LearningCenter{" +
                "learningCenterId=" + learningCenterId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                ", phone='" + phone + '\'' +
                ", webpage='" + webpage + '\'' +
                ", email='" + email + '\'' +
                ", establishedDate=" + establishedDate +
                ", createdAt=" + createdAt +
                '}';
    }
}
