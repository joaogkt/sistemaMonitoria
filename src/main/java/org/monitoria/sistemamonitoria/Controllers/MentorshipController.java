package org.monitoria.sistemamonitoria.Controllers;

import org.monitoria.sistemamonitoria.DTO.MentorshipDTO;
import org.monitoria.sistemamonitoria.DTO.MentorshipResponseDTO;
import org.monitoria.sistemamonitoria.Models.Mentorship;
import org.monitoria.sistemamonitoria.Services.MentorshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentorships")
public class MentorshipController {

    @Autowired
    private MentorshipService mentorshipService;

    @GetMapping
    public ResponseEntity<List<MentorshipResponseDTO>> getAll() {
        List<MentorshipResponseDTO> mentorships = mentorshipService.findAll()
                .stream()
                .map(m -> {
                    MentorshipResponseDTO dto = new MentorshipResponseDTO();
                    dto.setId(m.getId());
                    dto.setTitle(m.getTitle());
                    dto.setSubject(m.getSubject());
                    dto.setContactLink(m.getContactLink());
                    dto.setCreatedByName(m.getCreatedBy().getEmail());
                    return dto;
                })
                .toList();
        ;
        return ResponseEntity.ok(mentorships);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentorshipResponseDTO> getById(@PathVariable Long id) {
        return mentorshipService.findById(id)
                .map(MentorshipResponseDTO::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mentorship> create(@Validated @RequestBody MentorshipDTO dto) {
        Mentorship mentorship = mentorshipService.save(dto);
        return ResponseEntity.ok(mentorship);
    }

//    @PostMapping
//    public ResponseEntity<String> testCreateMentorship() {
//        System.out.println(">>> O CONTROLLER FOI ALCANÇADO COM SUCESSO! <<<");
//        return ResponseEntity.ok("SE VOCÊ VÊ ISTO, O PROBLEMA É O REQUEST BODY!");
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Mentorship> update(@PathVariable Long id, @Validated @RequestBody MentorshipDTO dto) {
        Mentorship updatedMentorship = mentorshipService.update(id, dto);
        return ResponseEntity.ok(updatedMentorship);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mentorshipService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
