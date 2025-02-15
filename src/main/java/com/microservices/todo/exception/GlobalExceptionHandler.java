package com.microservices.todo.exception;

import com.microservices.todo.common.enums.ApiStatus;
import com.microservices.todo.dto.common.ApiError;
import com.microservices.todo.dto.common.ValidationError;
import com.microservices.todo.util.MessageUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler{
    private final MessageUtil messageUtil;

    @ExceptionHandler(WebExchangeBindException.class)
    protected Mono<ResponseEntity<ApiError>> handleWebExchangeBindException(WebExchangeBindException ex, ServerWebExchange exchange) {
        List<ValidationError> errors = ex.getFieldErrors()
                .stream()
                .map(fieldError -> ValidationError.builder()
                        .field(fieldError.getField())
                        .errorMessage(fieldError.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        ApiError message = ApiError.builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getURI().getPath())
                .status(ApiStatus.VALIDATION_ERROR.getCode())
                .error(messageUtil.getMessage(ApiStatus.VALIDATION_ERROR.getMessageKey()))
                .errors(errors)
                .build();

        return Mono.just(ResponseEntity
                .status(ApiStatus.VALIDATION_ERROR.getCode())
                .body(message));
    }
}
