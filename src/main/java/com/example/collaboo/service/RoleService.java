// RoleService.java
package com.example.collaboo.service;

import com.example.collaboo.domain.Role;
import com.example.collaboo.domain.Project;
import com.example.collaboo.dto.RoleDTO;
import com.example.collaboo.repository.ProjectRepository;
import com.example.collaboo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public void addRole(Long projectId, RoleDTO roleDTO) {
        // 프로젝트 ID로 프로젝트를 가져옴
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("프로젝트를 찾을 수 없음"));

        // 역할 생성 및 설정
        Role role = new Role();
        role.setProject(project);
        role.setRolename(roleDTO.getRolename());
        role.setPerson(roleDTO.getPerson());
        role.setStart(roleDTO.getStart());
        role.setEnd(roleDTO.getEnd());
        role.setDescription(roleDTO.getDescription());

        // 역할 저장
        roleRepository.save(role);
    }
}
