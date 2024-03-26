// TaskService.java
package com.example.collaboo.service;

import com.example.collaboo.domain.Project;
import com.example.collaboo.domain.Task;
import com.example.collaboo.dto.TaskDTO;
import com.example.collaboo.repository.ProjectRepository;
import com.example.collaboo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public void createTask(Long projectId, TaskDTO taskDTO) {
        // 프로젝트 ID로 프로젝트를 가져옴
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new IllegalArgumentException("프로젝트를 찾을 수 없음"));

        Task task = new Task();
        task.setProject(project);
        task.setTodo(taskDTO.getTodo());
        task.setCompleted(taskDTO.isCompleted());
        taskRepository.save(task);
    }
}
