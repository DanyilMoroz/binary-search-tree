package com.binarysearchtree.validation.validator;

import com.binarysearchtree.validation.annotation.ValidNumbersString;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class NumbersStringValidator implements ConstraintValidator<ValidNumbersString, String> {

    @Override
    public void initialize(ValidNumbersString constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        String[] parts = value.split(",");
        Set<String> seenNumbers = new HashSet<>();

        for (String part : parts) {
            String trimmedPart = part.trim();

            if (!isValidNumber(trimmedPart)) {
                return false;
            }

            if (!seenNumbers.add(trimmedPart)) {
                // Duplicate number found
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