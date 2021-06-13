package com.digitalhouse.desafioquality.dto.request.validation;

import com.digitalhouse.desafioquality.dto.request.PropertyRequest;
import com.digitalhouse.desafioquality.dto.request.RoomRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Set;

public class PropertyRequestRulesTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void shouldValidateInvalidPropertyNameInvalidLength() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, 10.0);
        PropertyRequest request = new PropertyRequest("Ca", "Adalgisa", Arrays.asList(room));
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidPropertyNameInvalidFirstLetterUpperCase() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, 10.0);
        PropertyRequest request = new PropertyRequest("casa", "Adalgisa", Arrays.asList(room));
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidPropertyNameInvalidNull() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, 10.0);
        PropertyRequest request = new PropertyRequest(null, "Adalgisa", Arrays.asList(room));
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidPropertyNameInvalidBlank() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, 10.0);
        PropertyRequest request = new PropertyRequest("    ", "Adalgisa", Arrays.asList(room));
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidPropertyDistrictInvalidLength() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, 10.0);
        PropertyRequest request = new PropertyRequest("Casa", "Ad", Arrays.asList(room));
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidPropertyDistrictInvalidFirstLetterUpperCase() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, 10.0);
        PropertyRequest request = new PropertyRequest("Casa", "adalgisa", Arrays.asList(room));
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidPropertyDistrictInvalidNull() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, 10.0);
        PropertyRequest request = new PropertyRequest("Casa", null, Arrays.asList(room));
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidPropertyDistrictInvalidBlank() {
        RoomRequest room = new RoomRequest("Sala de estar", 10.0, 10.0);
        PropertyRequest request = new PropertyRequest("Casa", "     ", Arrays.asList(room));
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomsNull() {
        PropertyRequest request = new PropertyRequest("Casa", "Adalgisa", null);
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    public void shouldValidateInvalidRoomsEmpty() {
        PropertyRequest request = new PropertyRequest("Casa", "Adalgisa", Arrays.asList());
        Set<ConstraintViolation<PropertyRequest>> violations = validator.validate(request);
        Assertions.assertFalse(violations.isEmpty());
    }

}
