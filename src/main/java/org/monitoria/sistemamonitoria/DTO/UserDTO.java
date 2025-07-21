package org.monitoria.sistemamonitoria.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.monitoria.sistemamonitoria.Enums.Role;

@Setter
@Getter
public class UserDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Size(min = 8, message = "Senha deve ter no mínimo 6 caracteres")
    private String password;

    private Role role;

}
