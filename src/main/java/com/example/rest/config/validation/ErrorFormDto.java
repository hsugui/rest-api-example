package com.example.rest.config.validation;

import lombok.Data;

@Data
public class ErrorFormDto {

    private String field;
    private String errorMessage;

    public ErrorFormDto(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }

}
