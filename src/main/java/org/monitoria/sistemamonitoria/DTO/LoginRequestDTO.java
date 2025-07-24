package org.monitoria.sistemamonitoria.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {

    @Email
    private String email;

    @NotBlank
    private String password;

//    @NotBlank
//    private String role;
}
