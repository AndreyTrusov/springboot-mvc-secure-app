package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "event_tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagId;

    @NotBlank(message = "Tag name is required")
    @Size(max = 50, message = "Tag name cannot exceed 50 characters")
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public @NotBlank(message = "Tag name is required") @Size(max = 100, message = "Tag name cannot exceed 100 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Tag name is required") @Size(max = 100, message = "Tag name cannot exceed 100 characters") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", name='" + name + '\'' +
                '}';
    }
}

