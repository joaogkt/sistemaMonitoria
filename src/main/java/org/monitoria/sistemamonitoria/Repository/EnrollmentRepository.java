package org.monitoria.sistemamonitoria.Repository;

import org.monitoria.sistemamonitoria.Models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
