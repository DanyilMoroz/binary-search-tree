package com.binarysearchtree.validation.validator;

import com.binarysearchtree.validation.annotation.ValidNumbersString;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumbersStringValidator implements ConstraintValidator<ValidNumbersString, String> {

    @Override
    public void initialize(ValidNumbersString constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        // Split the input string by commas and trim each part
        String[] parts = value.split(",");
        for (String part : parts) {
            if (!isValidNumber(part.trim())) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidNumber(String part) {
        try {
            Double.parseDouble(part); // Try parsing each part as a double
            return true;
        } catch (NumberFormatException e) {
            return false; // Not a valid number
        }
    }
}
