package com.assu.study.common;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidationErrorException extends RuntimeException {
    private List<ValidationError> errors;

    public ValidationErrorException(List<ValidationError> errors) {
        this.errors = errors;
    }
}
