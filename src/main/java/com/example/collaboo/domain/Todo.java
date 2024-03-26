package com.example.collaboo.domain;

import jakarta.persistence.*;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "tasks")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @Column(name = "todo", columnDefinition = "TEXT")
    private String todo;

    @Column(name = "completed", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean completed;

}
