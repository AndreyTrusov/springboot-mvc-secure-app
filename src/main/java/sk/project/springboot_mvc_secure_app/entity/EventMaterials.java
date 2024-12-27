package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

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

    public Long getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(Long materialsId) {
        this.materialsId = materialsId;
    }

    public @NotNull(message = "Event ID is required") Long getEventId() {
        return eventId;
    }

    public void setEventId(@NotNull(message = "Event ID is required") Long eventId) {
        this.eventId = eventId;
    }

    public @NotBlank(message = "Description is required") @Size(max = 255, message = "Description cannot exceed 255 characters") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is required") @Size(max = 255, message = "Description cannot exceed 255 characters") String description) {
        this.description = description;
    }

    public @Size(max = 500, message = "File path cannot exceed 500 characters") String getFilePath() {
        return filePath;
    }

    public void setFilePath(@Size(max = 500, message = "File path cannot exceed 500 characters") String filePath) {
        this.filePath = filePath;
    }

    public @Size(max = 500, message = "Link cannot exceed 500 characters") String getLink() {
        return link;
    }

    public void setLink(@Size(max = 500, message = "Link cannot exceed 500 characters") String link) {
        this.link = link;
    }

    public @Size(max = 50, message = "File Type cannot exceed 50 characters") String getFileType() {
        return fileType;
    }

    public void setFileType(@Size(max = 50, message = "File Type cannot exceed 50 characters") String fileType) {
        this.fileType = fileType;
    }

    public LocalDate getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDate uploadedAt) {
        this.uploadedAt = uploadedAt;
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
