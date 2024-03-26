// ProjectController.java
package com.example.collaboo.controller;

import com.example.collaboo.dto.ProjectDTO;
import com.example.collaboo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/projects")
    public ResponseEntity<String> createProject(@RequestBody ProjectDTO projectDTO) {
        try {
            projectService.createProject(projectDTO);
            return ResponseEntity.ok("프로젝트가 성공적으로 생성되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("프로젝트 생성 중 오류가 발생했습니다.");
        }
    }
    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
