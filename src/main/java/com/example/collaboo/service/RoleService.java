package com.example.collaboo.service;

import com.example.collaboo.domain.Role;
import com.example.collaboo.domain.Project;
import com.example.collaboo.dto.RoleDTO;
import com.example.collaboo.repository.ProjectRepository;
import com.example.collaboo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<RoleDTO> getAllRolesByProjectId(Long projectId) {
        List<Role> roles = roleRepository.findByProjectId(projectId);
        return roles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private RoleDTO convertToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRolename(role.getRolename());
        roleDTO.setPerson(role.getPerson());
        roleDTO.setStart(role.getStart());
        roleDTO.setEnd(role.getEnd());
        roleDTO.setDescription(role.getDescription());
        return roleDTO;
    }

    public void updateRole(Long projectId, Long roleId, RoleDTO roleDTO) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            role.setRolename(roleDTO.getRolename());
            role.setPerson(roleDTO.getPerson());
            role.setStart(roleDTO.getStart());
            role.setEnd(roleDTO.getEnd());
            role.setDescription(roleDTO.getDescription());

            roleRepository.save(role);
        } else {
            throw new IllegalArgumentException("해당 역할을 찾을 수 없음");
        }
    }
    public void deleteRole(Long projectId, Long roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            roleRepository.delete(role);
        } else {
            throw new IllegalArgumentException("해당 역할을 찾을 수 없음");
        }
    }

}