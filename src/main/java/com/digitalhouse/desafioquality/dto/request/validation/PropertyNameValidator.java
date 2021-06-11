package com.digitalhouse.desafioquality.dto.request.validation;

import com.digitalhouse.desafioquality.controller.configuration.exceptions.FieldMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PropertyNameValidator implements ConstraintValidator<PropertyNameValidation, String> {

    private final List<FieldMessage> ERRORS_MESSAGES = new ArrayList<>();
    private final String BLANK_MESSAGE = "Mandatory filling.";
    private final String INVALID_LENGTH_MESSAGE = "The property name must be between 3 or 30 characters.";
    private final String NOT_FIRST_LETTER_UPPERCASE_MESSAGE = "The name must start with a capital letter.";
    private final Integer MIN_LENGTH = 3;
    private final Integer MAX_LENGTH = 30;

    @Override
    public void initialize(PropertyNameValidation propertyNameValidation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        ERRORS_MESSAGES.clear();

        if (name == null || name.isBlank()) {
            this.addAllErrors();
        } else {
            if (hasLengthValid(name)) {
                this.addError(INVALID_LENGTH_MESSAGE);
            }

            if (!isFirstLetterUpperCase(name)) {
                this.addError(NOT_FIRST_LETTER_UPPERCASE_MESSAGE);
            }
        }

        for (FieldMessage e : ERRORS_MESSAGES) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage())
                    .addConstraintViolation();
        }

        return ERRORS_MESSAGES.isEmpty();
    }

    private boolean isFirstLetterUpperCase(String name) {
        char c = name.charAt(0);
        return Character.isUpperCase(c);
    }

    private boolean hasLengthValid(String name) {
        Integer length = name.length();
        if (length < MIN_LENGTH || length > MAX_LENGTH)
            return true;
        return false;
    }

    private void addAllErrors() {
        ERRORS_MESSAGES.add(new FieldMessage("propertyName", BLANK_MESSAGE));
        ERRORS_MESSAGES.add(new FieldMessage("propertyName", INVALID_LENGTH_MESSAGE));
        ERRORS_MESSAGES.add(new FieldMessage("propertyName", NOT_FIRST_LETTER_UPPERCASE_MESSAGE));
    }

    private void addError(String error) {
        ERRORS_MESSAGES.add(new FieldMessage("propertyName", error));
    }

}
