package org.monitoria.sistemamonitoria.Controllers;

import org.monitoria.sistemamonitoria.DTO.MentorshipDTO;
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
    public ResponseEntity<List<Mentorship>> getAll() {
        List<Mentorship> mentorships = mentorshipService.findAll();
        return ResponseEntity.ok(mentorships);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mentorship> getById(@PathVariable Long id) {
        return mentorshipService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mentorship> create(@Validated @RequestBody MentorshipDTO dto) {
        Mentorship mentorship = mentorshipService.save(dto);
        return ResponseEntity.ok(mentorship);
    }

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
