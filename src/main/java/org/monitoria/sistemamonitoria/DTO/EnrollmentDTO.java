package org.monitoria.sistemamonitoria.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnrollmentDTO {

    @NotNull(message = "ID do usuário é obrigatório")
    private Long userId;

    @NotNull(message = "ID da mentoria é obrigatório")
    private Long mentorshipId;

}
