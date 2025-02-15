package com.microservices.todo.dto.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T>{
    private Timestamp timestamp;
    private String path;
    private int status;
    private boolean success;
    private String message;
    private T data;
}
