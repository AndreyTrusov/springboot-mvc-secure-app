package sk.project.springboot_mvc_secure_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.project.springboot_mvc_secure_app.dto.UserPasswordDTO;
import sk.project.springboot_mvc_secure_app.dto.UserProfileDTO;
import sk.project.springboot_mvc_secure_app.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findByEmail(String email);
    List<User> findAllByIsActiveTrue();
    User save(User user);

    @Modifying
    @Query("UPDATE User u SET " +
            "u.name = :#{#user.name}, " +
            "u.phoneNumber = :#{#user.phoneNumber}, " +
            "u.company = :#{#user.company}, " +
            "u.jobTitle = :#{#user.jobTitle}, " +
            "u.address = :#{#user.address}, " +
            "u.gender = :#{#user.gender}, " +
            "u.dateOfBirth = :#{#user.dateOfBirth} " +
            "WHERE u.id = :#{#user.id}")
    int updateUser(@Param("user") UserProfileDTO user);

    @Modifying
    @Query("UPDATE User u SET " +
            "u.passwordHash = :#{#user.passwordHash} " +
            "WHERE u.id = :#{#user.id}")
    int updateUserPassword(@Param("user") UserPasswordDTO user);

}
