package com.digitalhouse.desafioquality.dto.request.validation;

import com.digitalhouse.desafioquality.controller.configuration.exceptions.FieldMessage;
import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.request.RoomRequest;
import com.digitalhouse.desafioquality.dto.request.validation.utils.RulesUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PropertyRequestRules implements ConstraintValidator<PropertyRequestValidation, PropertyRequest> {

    private final List<FieldMessage> ERRORS_MESSAGES = new ArrayList<>();
    private final String BLANK_MESSAGE = "Mandatory filling.";
    private final String INVALID_LENGTH_MESSAGE = "The %1$s must be between %2$d and %3$d characters.";
    private final String NOT_FIRST_LETTER_UPPERCASE_MESSAGE = "The %1$s must start with a capital letter.";
    private final Integer MIN_NAME_LENGTH = 3, MAX_NAME_LENGTH = 30;
    private final Integer MIN_DISRTICT_LENGTH = 3, MAX_DISTRICT_LENGTH = 30;

    @Override
    public void initialize(PropertyRequestValidation propertyNameValidation) {
    }

    @Override
    public boolean isValid(PropertyRequest obj, ConstraintValidatorContext context) {
        ERRORS_MESSAGES.clear();

        this.validatePropertyName(obj.getPropertyName());
        this.validatePropertyDistrict(obj.getPropertyDistrict());
        this.validateIfRoomsExists(obj.getRooms());

        ERRORS_MESSAGES.stream().forEach(e -> {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        });

        return ERRORS_MESSAGES.isEmpty();
    }

    private void validatePropertyName(String name) {
        String field = "propertyName", fieldName = "property name";
        if (RulesUtils.isNull(name) || RulesUtils.isBlank(name)) {
            this.addError(field, BLANK_MESSAGE);
            this.addError(field, String.format(INVALID_LENGTH_MESSAGE, fieldName, MIN_NAME_LENGTH, MAX_NAME_LENGTH));
            this.addError(field, String.format(NOT_FIRST_LETTER_UPPERCASE_MESSAGE, fieldName));
        } else {
            if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
                this.addError(field, String.format(INVALID_LENGTH_MESSAGE, fieldName, MIN_NAME_LENGTH, MAX_NAME_LENGTH));

            if (!RulesUtils.isFirstLetterUpperCase(name))
                this.addError(field, String.format(NOT_FIRST_LETTER_UPPERCASE_MESSAGE, fieldName));
        }
    }

    private void validatePropertyDistrict(String name) {
        String field = "propertyDistrict", fieldName = "property district";
        Integer minLength = 3, maxLength = 45;
        if (RulesUtils.isNull(name) || RulesUtils.isBlank(name)) {
            this.addError(field, BLANK_MESSAGE);
            this.addError(field, String.format(INVALID_LENGTH_MESSAGE, fieldName, minLength, maxLength));
            this.addError(field, String.format(NOT_FIRST_LETTER_UPPERCASE_MESSAGE, fieldName));
        } else {
            if (name.length() < MIN_DISRTICT_LENGTH || name.length() > MAX_DISTRICT_LENGTH)
                this.addError(field, String.format(INVALID_LENGTH_MESSAGE, fieldName, minLength, maxLength));

            if (!RulesUtils.isFirstLetterUpperCase(name))
                this.addError(field, String.format(NOT_FIRST_LETTER_UPPERCASE_MESSAGE, fieldName));
        }
    }

    private void validateIfRoomsExists(List<RoomRequest> listRoom) {
        String field = "rooms";
        if (listRoom == null || listRoom.isEmpty()) {
            this.addError(field, "The rooms must be filled");
        }
    }

    private void addError(String field, String error) {
        ERRORS_MESSAGES.add(new FieldMessage(field, error));
    }

}
