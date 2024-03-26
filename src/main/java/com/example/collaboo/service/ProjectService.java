package com.example.collaboo.service;

import com.example.collaboo.domain.Project;
import com.example.collaboo.dto.ProjectDTO;
import com.example.collaboo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setProject(projectDTO.getProject());
        project.setTeams(projectDTO.getTeams());
        project.setStart(projectDTO.getStart());
        project.setEnd(projectDTO.getEnd());
        project.setDescription(projectDTO.getDescription());

        projectRepository.save(project);
    }

    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProjectDTO convertToDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProject(project.getProject());
        projectDTO.setTeams(project.getTeams());
        projectDTO.setStart(project.getStart());
        projectDTO.setEnd(project.getEnd());
        projectDTO.setDescription(project.getDescription());
        return projectDTO;
    }
}
