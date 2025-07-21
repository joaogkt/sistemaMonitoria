package org.monitoria.sistemamonitoria.Repository;

import org.monitoria.sistemamonitoria.Models.Mentorship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorshipRepository extends JpaRepository<Mentorship, Long> {
    
}
