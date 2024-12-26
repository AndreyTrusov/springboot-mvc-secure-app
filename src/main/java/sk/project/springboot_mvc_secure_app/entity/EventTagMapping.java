package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "event_tag_mapping")
public class EventTagMapping {

//    @EmbeddedId
//    private EventTagMappingId id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Event ID is required")
    @Column(name = "EventID", nullable = false)
    private Long eventId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Tag ID is required")
    @Column(name = "TagID", nullable = false)
    private Long tagId;

    @Column(name = "MappedAt", nullable = false, updatable = false)
    private LocalDate mappedAt;

    public EventTagMapping() {
        this.mappedAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "EventTagMapping{" +
                ", eventId=" + eventId +
                ", tagId=" + tagId +
                ", mappedAt=" + mappedAt +
                '}';
    }

}

