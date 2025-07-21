package org.monitoria.sistemamonitoria.Controllers;

import org.monitoria.sistemamonitoria.DTO.EnrollmentDTO;
import org.monitoria.sistemamonitoria.Models.Enrollment;
import org.monitoria.sistemamonitoria.Services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAll() {
        List<Enrollment> enrollments = enrollmentService.findAll();
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getById(@PathVariable Long id) {
        return enrollmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Enrollment> create(@Validated @RequestBody EnrollmentDTO dto) {
        Enrollment enrollment = enrollmentService.save(dto);
        return ResponseEntity.ok(enrollment);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Enrollment> update(@PathVariable Long id, @Validated @RequestBody EnrollmentDTO dto) {
//        Enrollment updatedEnrollment = enrollmentService.update(id, dto);
//        return ResponseEntity.ok(updatedEnrollment);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enrollmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
