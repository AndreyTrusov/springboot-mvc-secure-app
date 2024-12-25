package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EventID")
    private Long eventId;

    @NotBlank(message = "Event name is required")
    @Size(min = 3, max = 100, message = "Event name must be between 3 and 100 characters")
    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "IsPrivate", nullable = false)
    private Boolean isPrivate = false;

    @Column(name = "CreatedBy", nullable = false)
    private Long createdBy;

    @Column(name = "Description")
    private String description;

    @Column(name = "CreatedAt", updatable = false)
    private LocalDate createdAt;

    public Event() {
        this.createdAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", name='" + name + '\'' +
                ", isPrivate=" + isPrivate +
                ", createdBy=" + createdBy +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
