package org.monitoria.sistemamonitoria.Controllers;

import org.monitoria.sistemamonitoria.DTO.SubjectDTO;
import org.monitoria.sistemamonitoria.DTO.UserDTO;
import org.monitoria.sistemamonitoria.Models.Subject;
import org.monitoria.sistemamonitoria.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubjects() {
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Subject> getSubject(@PathVariable long id) {
        return subjectService.findById(id);
    }

    @PostMapping
    public Subject createSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.save(subjectDTO);
    }
    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable long id, @RequestBody SubjectDTO subjectDTO) {
        return subjectService.update(id, subjectDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable long id) {
        subjectService.delete(id);
    }
}
