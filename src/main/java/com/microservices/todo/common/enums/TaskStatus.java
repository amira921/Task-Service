package com.microservices.todo.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.support.WebExchangeBindException;

@AllArgsConstructor
public enum TaskStatus {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    DUE_SOON("Due Soon"),
    OVER_DUE("Overdue"),
    NO_TYPE("No Type"),
    TODAY("Today"),
    NEXT_WEEK("Next Week");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TaskStatus fromString(String value) {
        TaskStatus status = null;
        if (value == null || value.trim().isEmpty()) {
            FieldError fieldError = new FieldError(
                    "taskStatus",
                    "taskStatus",
                    value,
                    false,
                    new String[] {
                            "Please enter a valid Task Status:\n" +
                                    "1. TODO\n" +
                                    "2. IN_PROGRESS\n" +
                                    "3. COMPLETED\n" +
                                    "4. DUE_SOON\n" +
                                    "5. OVER_DUE\n" +
                                    "6. NO_TYPE\n" +
                                    "7. TODAY\n" +
                                    "8. NEXT_WEEK\n"
                    },
                    new Object[] {value},
                    "Please enter a valid Task Status:\n" +
                            "1. TODO\n" +
                            "2. IN_PROGRESS\n" +
                            "3. COMPLETED\n" +
                            "4. DUE_SOON\n" +
                            "5. OVER_DUE\n" +
                            "6. NO_TYPE\n" +
                            "7. TODAY\n" +
                            "8. NEXT_WEEK\n"
            );
            BindingResult bindingResult = new BeanPropertyBindingResult("taskStatus", "taskStatus");
            bindingResult.addError(fieldError);
            MethodParameter methodParameter = new MethodParameter(TaskStatus.class.getDeclaredMethods()[0], 0);
            throw new WebExchangeBindException(methodParameter, bindingResult);
        }
        for (TaskStatus taskStatus : TaskStatus.values()) {
            if (taskStatus.getValue().equalsIgnoreCase(value.trim())) status = taskStatus;
        }
        return status;
    }
}
