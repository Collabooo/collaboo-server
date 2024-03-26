// ProjectService.java
package com.example.collaboo.service;

import com.example.collaboo.domain.Project;
import com.example.collaboo.domain.User;
import com.example.collaboo.dto.ProjectDTO;
import com.example.collaboo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;



    public void createProject(ProjectDTO projectDTO) {


        // Project 엔티티 생성 및 데이터 셋팅
        Project project = new Project();
        project.setProject(projectDTO.getProject());
        project.setTeams(projectDTO.getTeams());
        project.setStart(projectDTO.getStart());
        project.setEnd(projectDTO.getEnd());
        project.setDescription(projectDTO.getDescription());



        // 프로젝트 저장
        projectRepository.save(project);
    }
}
