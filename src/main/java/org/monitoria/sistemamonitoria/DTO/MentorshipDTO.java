package org.monitoria.sistemamonitoria.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.monitoria.sistemamonitoria.Enums.MentorshipType;

@Setter
@Getter
public class MentorshipDTO {

    @NotBlank(message = "Título é obrigatório")
    private String title;

    private String description;

    @NotNull(message = "Nome da matéria é obrigatório")
    private String subject;

    @NotNull(message = "Tipo de mentoria é obrigatório")
    private MentorshipType type;

    @NotBlank(message = "Link de contato é obrigatório")
    private String contactLink;

    @NotNull(message = "ID do criador é obrigatório")
    private Long createdById;



}
