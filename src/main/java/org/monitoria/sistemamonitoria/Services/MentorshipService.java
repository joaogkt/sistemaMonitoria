package org.monitoria.sistemamonitoria.Services;

import org.monitoria.sistemamonitoria.DTO.MentorshipDTO;
import org.monitoria.sistemamonitoria.Models.Mentorship;
import org.monitoria.sistemamonitoria.Models.User;
import org.monitoria.sistemamonitoria.Repository.MentorshipRepository;
import org.monitoria.sistemamonitoria.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorshipService {

    @Autowired
    private MentorshipRepository mentorshipRepository;

    @Autowired
    private UserRepository userRepository;

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
        mentorship.setSubject(dto.getSubject());
        User user = userRepository.findById(dto.getCreatedById())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        mentorship.setCreatedBy(user);
        return mentorshipRepository.save(mentorship);
    }

    public Mentorship update(Long id, MentorshipDTO dto) {
        Mentorship mentorship = findById(id)
                .orElseThrow(() -> new RuntimeException("Mentorship not found"));
        mentorship.setTitle(dto.getTitle());
        mentorship.setDescription(dto.getDescription());
        mentorship.setType(dto.getType());
        mentorship.setContactLink(dto.getContactLink());
        mentorship.setSubject(dto.getSubject());
        User user = userRepository.findById(dto.getCreatedById())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        mentorship.setCreatedBy(user);
        return mentorshipRepository.save(mentorship);
    }

    public void deleteById(Long id) {
        mentorshipRepository.deleteById(id);
    }
}
