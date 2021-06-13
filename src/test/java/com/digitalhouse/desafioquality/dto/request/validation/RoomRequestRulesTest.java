package com.digitalhouse.desafioquality.dto.request.validation;

import com.digitalhouse.desafioquality.dto.request.RoomRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class RoomRequestRulesTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void shouldValidateInvalidRoomNameInvalidLength() {
        RoomRequest room = new RoomRequest("Sa", 10.0, 10.0);
        Set<ConstraintViolation<RoomRequest>> violations = validator.validate(room);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomNameInvalidFirstLetterUpperCase() {
        RoomRequest room = new RoomRequest("sala de estar", 10.0, 10.0);
        Set<ConstraintViolation<RoomRequest>> violations = validator.validate(room);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomNameInvalidNull() {
        RoomRequest room = new RoomRequest(null, 10.0, 10.0);
        Set<ConstraintViolation<RoomRequest>> violations = validator.validate(room);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomNameInvalidBlank() {
        RoomRequest room = new RoomRequest("    ", 10.0, 10.0);
        Set<ConstraintViolation<RoomRequest>> violations = validator.validate(room);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomWidthNull() {
        RoomRequest room = new RoomRequest("Sala de estar", null, 10.0);
        Set<ConstraintViolation<RoomRequest>> violations = validator.validate(room);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomWidthSmallerThanMinimum() {
        RoomRequest room = new RoomRequest("Sala de estar", 0.0, 10.0);
        Set<ConstraintViolation<RoomRequest>> violations = validator.validate(room);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomWidthBiggerThanMinimum() {
        RoomRequest room = new RoomRequest("Sala de estar", 26.0, 10.0);
        Set<ConstraintViolation<RoomRequest>> violations = validator.validate(room);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomLengthNull() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, null);
        Set<ConstraintViolation<RoomRequest>> violations = validator.validate(room);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomLengthSmallerThanMinimum() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, 0.0);
        Set<ConstraintViolation<RoomRequest>> violations = validator.validate(room);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomLengthBiggerThanMinimum() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, 34.0);
        Set<ConstraintViolation<RoomRequest>> violations = validator.validate(room);
        Assertions.assertFalse(violations.isEmpty());
    }

}
