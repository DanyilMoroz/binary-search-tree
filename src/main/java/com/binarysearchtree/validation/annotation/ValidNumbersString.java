package com.binarysearchtree.validation.annotation;

import com.binarysearchtree.validation.validator.NumbersStringValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumbersStringValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNumbersString {

    String message() default "Invalid numbers format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
