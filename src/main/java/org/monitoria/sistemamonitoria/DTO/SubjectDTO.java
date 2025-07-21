package org.monitoria.sistemamonitoria.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubjectDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String name;


}