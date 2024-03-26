package com.example.collaboo.domain;

import com.example.collaboo.domain.Project;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @Column(name = "rolename", length = 100)
    private String rolename;

    @Column(name = "person", length = 255)
    private String person;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    @Column(name = "description", length = 255)
    private String description;

}
