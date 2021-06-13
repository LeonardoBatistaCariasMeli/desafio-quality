package com.digitalhouse.desafioquality.dto.request.validation;

import com.digitalhouse.desafioquality.controller.configuration.exceptions.FieldMessage;
import com.digitalhouse.desafioquality.dto.request.RoomRequest;
import com.digitalhouse.desafioquality.dto.request.validation.utils.RulesUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class RoomRequestRules implements ConstraintValidator<RoomRequestValidation, RoomRequest> {
    private final List<FieldMessage> ERRORS_MESSAGES = new ArrayList<>();
    private final String BLANK_MESSAGE = "Mandatory filling.";
    private final String INVALID_LENGTH_MESSAGE = "The %1$s must be between %2$d and %3$d characters.";
    private final String NOT_FIRST_LETTER_UPPERCASE_MESSAGE = "The %1$s must start with a capital letter.";
    private final String SIDEWAYS_ERROR_MESSAGE = "The %1$s must be between %2$d and %3$d.";
    private final Integer MIN_NAME_LENGTH = 3, MAX_NAME_LENGTH = 30;
    private final Integer MIN_WIDTH = 1, MAX_WIDTH = 25;
    private final Integer MIN_LENGTH = 1, MAX_LENGTH = 33;

    @Override
    public void initialize(RoomRequestValidation roomRequestValidation) {
    }

    @Override
    public boolean isValid(RoomRequest obj, ConstraintValidatorContext context) {
        ERRORS_MESSAGES.clear();

        this.validateRoomName(obj.getRoomName());
        this.validateRoomWidth(obj.getRoomWidth());
        this.validateRoomWidth(obj.getRoomLength());

        ERRORS_MESSAGES.stream().forEach(e -> {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        });

        return ERRORS_MESSAGES.isEmpty();
    }

    private void validateRoomName(String name) {
        String field = "roomName", fieldName = "room name";

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

    private void validateRoomWidth(Double roomWidth) {
        String field = "roomWidth", fieldName = "room width";
        if (roomWidth == null) {
            this.addError(field, String.format(SIDEWAYS_ERROR_MESSAGE, fieldName, MIN_WIDTH, MAX_WIDTH));
        } else {
            if (roomWidth < MIN_WIDTH || roomWidth > MAX_WIDTH)
                this.addError(field, String.format(SIDEWAYS_ERROR_MESSAGE, fieldName, MIN_WIDTH, MAX_WIDTH));
        }
    }

    private void validateRoomLength(Double roomLength) {
        String field = "roomLength", fieldName = "room length";
        if (roomLength == null) {
            this.addError(field, String.format(SIDEWAYS_ERROR_MESSAGE, fieldName, MIN_LENGTH, MAX_LENGTH));
        } else {
            if (roomLength < MIN_WIDTH || roomLength > MAX_WIDTH)
                this.addError(field, String.format(SIDEWAYS_ERROR_MESSAGE, fieldName, MIN_LENGTH, MAX_LENGTH));
        }
    }

    private void addError(String field, String error) {
        ERRORS_MESSAGES.add(new FieldMessage(field, error));
    }
}
