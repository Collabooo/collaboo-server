// RoleRepository.java
package com.example.collaboo.repository;

import com.example.collaboo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByProjectId(Long projectId);
}