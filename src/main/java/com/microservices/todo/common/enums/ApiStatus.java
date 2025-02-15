package com.microservices.todo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApiStatus {
    SUCCESS(200, "success.operation"),
    VALIDATION_ERROR(400, "error.validation");

    private final int code;
    private final String messageKey;
}
