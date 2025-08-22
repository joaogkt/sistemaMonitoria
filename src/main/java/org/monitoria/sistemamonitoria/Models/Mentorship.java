package org.monitoria.sistemamonitoria.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.monitoria.sistemamonitoria.Enums.MentorshipType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Mentorship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String subject;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MentorshipType type;

    @Column(nullable = false)
    private String contactLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", nullable = false)
    private User createdBy;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
