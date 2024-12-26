package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.TagRepository;
import sk.project.springboot_mvc_secure_app.entity.Tag;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    @Transactional
    public Tag save(Tag tag) {
        if (tag == null) {
            throw new IllegalArgumentException("Tag object cannot be null");
        }
        return tagRepository.save(tag);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        boolean exists = tagRepository.existsById(id);

        if (exists) {
            tagRepository.deleteById(id);
            System.out.println("Tag with ID " + id + " deleted successfully.");
            return true;
        } else {
            System.out.println("Tag with ID " + id + " not found.");
            return false;
        }
    }
}

