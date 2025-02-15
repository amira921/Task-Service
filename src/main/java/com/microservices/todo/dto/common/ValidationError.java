package com.microservices.todo.dto.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationError {
    private String field;
    private String errorMessage;
}
