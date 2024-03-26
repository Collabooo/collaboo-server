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

    public ProjectDTO updateProject(Long projectId, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 프로젝트가 존재하지 않습니다."));

        // 클라이언트로부터 받은 정보로 프로젝트 정보 업데이트
        project.setProject(projectDTO.getProject());
        project.setTeams(projectDTO.getTeams());
        project.setStart(projectDTO.getStart());
        project.setEnd(projectDTO.getEnd());
        project.setDescription(projectDTO.getDescription());

        // 프로젝트 업데이트
        project = projectRepository.save(project);

        // 업데이트된 프로젝트 정보를 DTO로 변환하여 반환
        return convertToDTO(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}