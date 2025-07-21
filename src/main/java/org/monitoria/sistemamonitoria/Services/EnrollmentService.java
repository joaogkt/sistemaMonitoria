package org.monitoria.sistemamonitoria.Services;

import org.monitoria.sistemamonitoria.DTO.EnrollmentDTO;
import org.monitoria.sistemamonitoria.Models.Enrollment;
import org.monitoria.sistemamonitoria.Models.Mentorship;
import org.monitoria.sistemamonitoria.Models.User;
import org.monitoria.sistemamonitoria.Repository.EnrollmentRepository;
import org.monitoria.sistemamonitoria.Repository.MentorshipRepository;
import org.monitoria.sistemamonitoria.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MentorshipRepository mentorshipRepository;

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> findById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public Enrollment save(EnrollmentDTO dto) {
        Enrollment enrollment = new Enrollment();
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Mentorship mentorship = mentorshipRepository.findById(dto.getMentorshipId())
                .orElseThrow(() -> new RuntimeException("Mentorship not found"));

        enrollment.setUser(user);
        enrollment.setMentorship(mentorship);
        enrollment.setCreatedAt(LocalDateTime.now());
        return enrollmentRepository.save(enrollment);
    }

    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
