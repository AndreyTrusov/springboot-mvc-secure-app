package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "user_history")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HistoryID")
    private Long historyId;

    @NotNull(message = "User ID is required")
    @Column(name = "UserID", nullable = false)
    private Long userId;

    @NotNull(message = "Event ID is required")
    @Column(name = "EventID", nullable = false)
    private Long eventId;

    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private LocalDate createdAt;

    public UserHistory() {
        this.createdAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "historyId=" + historyId +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", createdAt=" + createdAt +
                '}';
    }
}

