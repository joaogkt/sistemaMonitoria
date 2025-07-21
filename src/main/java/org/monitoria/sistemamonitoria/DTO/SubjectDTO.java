package org.monitoria.sistemamonitoria.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SubjectDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}