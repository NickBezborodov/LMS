package com.example.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "")
public class Course {
    @Id
    private Long id;
}

/* Поле id	@Id, @GeneratedValue(strategy = GenerationType.IDENTITY)
Связи между entity	@ManyToOne, @OneToMany, @JoinColumn */