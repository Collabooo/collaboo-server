// ProjectRepository.java
package com.example.collaboo.repository;

import com.example.collaboo.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
