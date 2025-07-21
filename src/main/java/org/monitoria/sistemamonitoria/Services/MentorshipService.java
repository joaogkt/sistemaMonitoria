package org.monitoria.sistemamonitoria.Services;

import org.monitoria.sistemamonitoria.DTO.MentorshipDTO;
import org.monitoria.sistemamonitoria.Models.Mentorship;
import org.monitoria.sistemamonitoria.Models.Subject;
import org.monitoria.sistemamonitoria.Models.User;
import org.monitoria.sistemamonitoria.Repository.MentorshipRepository;
import org.monitoria.sistemamonitoria.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorshipService {

    @Autowired
    private MentorshipRepository mentorshipRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Mentorship> findAll() {
        return mentorshipRepository.findAll();
    }

    public Optional<Mentorship> findById(Long id) {
        return mentorshipRepository.findById(id);
    }

    public Mentorship save(MentorshipDTO dto) {
        Mentorship mentorship = new Mentorship();
        mentorship.setTitle(dto.getTitle());
        mentorship.setDescription(dto.getDescription());
        mentorship.setType(dto.getType());
        mentorship.setContactLink(dto.getContactLink());
        Subject subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        mentorship.setSubject(subject);
        return mentorshipRepository.save(mentorship);
    }

    public Mentorship update(Long id, MentorshipDTO dto) {
        Mentorship mentorship = findById(id)
                .orElseThrow(() -> new RuntimeException("Mentorship not found"));
        mentorship.setTitle(dto.getTitle());
        mentorship.setDescription(dto.getDescription());
        mentorship.setType(dto.getType());
        mentorship.setContactLink(dto.getContactLink());
        Subject subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        mentorship.setSubject(subject);
        return mentorshipRepository.save(mentorship);
    }

    public void deleteById(Long id) {
        mentorshipRepository.deleteById(id);
    }
}
