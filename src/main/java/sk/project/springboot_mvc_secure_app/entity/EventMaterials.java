package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "event_materials")
public class EventMaterials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaterialsID")
    private Long materialsId;

    @NotNull(message = "Event ID is required")
    @Column(name = "EventID", nullable = false)
    private Long eventId;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @Column(name = "Description", length = 255, nullable = false)
    private String description;

    @Size(max = 500, message = "File path cannot exceed 500 characters")
    @Column(name = "FilePath", length = 500)
    private String filePath;

    @Size(max = 500, message = "Link cannot exceed 500 characters")
    @Column(name = "Link", length = 500)
    private String link;

    @Size(max = 50, message = "File Type cannot exceed 50 characters")
    @Column(name = "FileType", length = 500)
    private String fileType;

    @Column(name = "UploadedAt", nullable = false, updatable = false)
    private LocalDate uploadedAt;

    public EventMaterials() {
        this.uploadedAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "EventMaterials{" +
                "materialsId=" + materialsId +
                ", eventId=" + eventId +
                ", description='" + description + '\'' +
                ", filePath='" + filePath + '\'' +
                ", link='" + link + '\'' +
                ", uploadedAt=" + uploadedAt +
                '}';
    }
}
