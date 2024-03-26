// RoleDTO.java
package com.example.collaboo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RoleDTO {
    private String rolename;
    private String person;
    private Date start;
    private Date end;
    private String description;
}
