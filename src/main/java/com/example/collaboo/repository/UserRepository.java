package com.example.collaboo.repository;// UserRepository.java
import com.example.collaboo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom queries or methods if needed
}
