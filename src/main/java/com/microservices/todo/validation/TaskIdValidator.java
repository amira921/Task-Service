package com.microservices.todo.validation;


import com.microservices.todo.validation.annotation.ValidEmail;
import com.microservices.todo.validation.annotation.ValidTaskId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.support.WebExchangeBindException;


public class TaskIdValidator implements ConstraintValidator<ValidTaskId, Long> {

    private static final String TASK_ID_REGEX = "^[0-9]+$";

    @Override
    public boolean isValid(Long taskId, ConstraintValidatorContext context) {
        if (taskId == null || String.valueOf(taskId).isEmpty() || !String.valueOf(taskId).matches(TASK_ID_REGEX)){
            FieldError fieldError = new FieldError(
                    "pathVariable",
                    "taskId",
                    taskId,
                    false,
                    new String[] {"Please enter a valid task id"},
                    new Object[] {taskId},
                    "Please enter a valid task id"
            );
            BindingResult bindingResult = new BeanPropertyBindingResult("pathVariable", "pathVariable");
            bindingResult.addError(fieldError);
            MethodParameter methodParameter = new MethodParameter(getClass().getDeclaredMethods()[0], 0);
            throw new WebExchangeBindException(methodParameter, bindingResult);
        }
        return true;
    }
}