package com.microservices.todo.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.support.WebExchangeBindException;

@AllArgsConstructor
public enum TaskCategory {
    PERSONAL("Personal"),
    WORK("Work");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TaskCategory fromString(String value) {
        TaskCategory category = null;
        if (value == null || value.trim().isEmpty()) {
            FieldError fieldError = new FieldError(
                    "taskCategory",
                    "taskCategory",
                    value,
                    false,
                    new String[] {
                            "Please enter a valid Task Category:\n" +
                                    "1. Work\n" +
                                    "2. Personal\n"
                    },
                    new Object[] {value},
                    "Please enter a valid Task Category:\n" +
                            "1. Work\n" +
                            "2. Personal\n"
            );
            BindingResult bindingResult = new BeanPropertyBindingResult("taskCategory", "taskCategory");
            bindingResult.addError(fieldError);
            MethodParameter methodParameter = new MethodParameter(TaskCategory.class.getDeclaredMethods()[0], 0);
            throw new WebExchangeBindException(methodParameter, bindingResult);
        }
        for (TaskCategory taskCategory : TaskCategory.values()) {
            if (taskCategory.getValue().equalsIgnoreCase(value.trim())) category = taskCategory;
        }
        return category;
    }
}
