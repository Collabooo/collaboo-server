package com.example.collaboo.domain;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "category", length = 10)
    private String category;

    @Column(name = "description", length = 255)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "code", length = 255)
    private String code;

}
