package com.microservices.todo.validation.annotation;

import com.microservices.todo.validation.TaskIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TaskIdValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTaskId {
    String message() default "Invalid taskId format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
