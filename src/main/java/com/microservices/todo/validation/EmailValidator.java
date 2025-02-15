package com.microservices.todo.validation;

import com.microservices.todo.validation.annotation.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.support.WebExchangeBindException;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private static final String EMAIL_REGEX = "^(?=.*@)(?=.*\\.)[A-Za-z._%+-]{10,}@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    @Override
    public boolean isValid(String userEmail, ConstraintValidatorContext context) {
        if (userEmail == null || userEmail.trim().isEmpty()) return false;
        if(userEmail.matches(EMAIL_REGEX)) return true;
        else {
            FieldError fieldError = new FieldError(
                    "pathVariable",
                    "userEmail",
                    userEmail,
                    false,
                    new String[] {"Please enter a valid e-mail address"},
                    new Object[] {userEmail},
                    "Please enter a valid e-mail address"
            );
            BindingResult bindingResult = new BeanPropertyBindingResult("pathVariable", "pathVariable");
            bindingResult.addError(fieldError);
            MethodParameter methodParameter = new MethodParameter(getClass().getDeclaredMethods()[0], 0);
            throw new WebExchangeBindException(methodParameter, bindingResult);
        }
    }
}

