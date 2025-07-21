package org.monitoria.sistemamonitoria.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.monitoria.sistemamonitoria.Enums.Role;

@Entity
@Getter
@Setter
@Table(name = "app_user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


}
