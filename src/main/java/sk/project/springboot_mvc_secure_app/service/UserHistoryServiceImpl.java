package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.UserHistoryRepository;
import sk.project.springboot_mvc_secure_app.entity.UserHistory;

import java.util.List;

@Service
public class UserHistoryServiceImpl implements UserHistoryService {

    private final UserHistoryRepository userHistoryRepository;

    @Autowired
    public UserHistoryServiceImpl(UserHistoryRepository userHistoryRepository) {
        this.userHistoryRepository = userHistoryRepository;
    }

    @Override
    public List<UserHistory> findByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        return userHistoryRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public UserHistory save(UserHistory userHistory) {
        if (userHistory == null) {
            throw new IllegalArgumentException("UserHistory object cannot be null");
        }
        return userHistoryRepository.save(userHistory);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        boolean exists = userHistoryRepository.existsById(id);

        if (exists) {
            userHistoryRepository.deleteById(id);
            System.out.println("UserHistory with ID " + id + " deleted successfully.");
            return true;
        } else {
            System.out.println("UserHistory with ID " + id + " not found.");
            return false;
        }
    }
}
