package com.example.rest.model.dto;

import com.example.rest.model.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    public UserDto() {

    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.birthDate = user.getBirthDate();
    }

}
