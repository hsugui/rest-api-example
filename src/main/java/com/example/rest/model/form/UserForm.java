package com.example.rest.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UserForm {

    @NotBlank(message = "Nome não pode estar em branco")
    private String name;
    @NotBlank @Email(message = "Endereço de e-mail inválido")
    private String email;
    @CPF(message = "Número de CPF inválido")
    private String cpf;
    @NotNull(message = "Data de nascimento não pode ser nula")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

}
