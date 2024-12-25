package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "event_schedule")
public class EventSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScheduleID")
    private Long scheduleId;

    @NotNull(message = "Event ID is required")
    @Column(name = "EventID", nullable = false)
    private Long eventId;

    @NotNull(message = "Learning Center ID is required")
    @Column(name = "LearningCenterID", nullable = false)
    private Long learningCenterId;

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date cannot be in the past")
    @Column(name = "StartDate", nullable = false)
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be in the future")
    @Column(name = "EndDate", nullable = false)
    private LocalDate endDate;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    @Column(name = "Duration", nullable = false)
    private Integer duration;

    @Min(value = 1, message = "Max tickets must be at least 1")
    @Column(name = "MaxTickets", nullable = false)
    private Integer maxTickets;

    @NotNull(message = "Ticket price is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Ticket price must be at least 0")
    @Digits(integer = 8, fraction = 2, message = "Ticket price must be a valid monetary value")
    @Column(name = "TicketPrice", nullable = false)
    private BigDecimal ticketPrice;

    @Column(name = "CreatedAt", updatable = false)
    private LocalDate createdAt;

    public EventSchedule() {
        this.createdAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "EventSchedule{" +
                "scheduleId=" + scheduleId +
                ", eventId=" + eventId +
                ", learningCenterId=" + learningCenterId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", duration=" + duration +
                ", maxTickets=" + maxTickets +
                ", ticketPrice=" + ticketPrice +
                ", createdAt=" + createdAt +
                '}';
    }
}

