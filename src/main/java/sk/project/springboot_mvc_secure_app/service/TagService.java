package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<Tag> findAll();
//    Optional<Tag> findById(Long id);
//    Tag findByName(String name);
    Tag save(Tag tag);
    boolean deleteById(Long id);
}
