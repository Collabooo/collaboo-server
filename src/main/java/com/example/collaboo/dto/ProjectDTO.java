// ProjectDTO.java
package com.example.collaboo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProjectDTO {
    private String project;
    private int teams;
    private Date start;
    private Date end;
    private String description;
}
