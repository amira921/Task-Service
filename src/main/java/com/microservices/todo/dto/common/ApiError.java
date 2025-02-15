package com.microservices.todo.dto.common;

import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class ApiError {
    private Timestamp timestamp;
    private String path;
    private int status;
    private String error;
    private List<?> errors;
}
