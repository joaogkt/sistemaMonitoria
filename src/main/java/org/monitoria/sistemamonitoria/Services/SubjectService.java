package org.monitoria.sistemamonitoria.Services;

import org.monitoria.sistemamonitoria.DTO.SubjectDTO;
import org.monitoria.sistemamonitoria.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.monitoria.sistemamonitoria.Models.Subject;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> findAll(){
        return subjectRepository.findAll();
    };
    public Optional<Subject> findById(long id){
        return subjectRepository.findById(id);
    }
    public Subject save(SubjectDTO dto){
        Subject subject = new Subject();
        subject.setName(dto.getName());
        return subjectRepository.save(subject);
    }

}
