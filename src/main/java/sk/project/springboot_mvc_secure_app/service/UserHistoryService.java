package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.UserHistory;

import java.util.List;
import java.util.Optional;

public interface UserHistoryService {
    List<UserHistory> findByUserId(Long userId);
//    Optional<UserHistory> findById(Long id);
    UserHistory save(UserHistory userHistory);
    boolean deleteById(Long id);
}