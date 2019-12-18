package com.example._23people.demo23ppl.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RUTValidator implements ConstraintValidator<RUTConstraint, String> {

    @Override
    public void initialize(RUTConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String rutField, ConstraintValidatorContext context) {
        return  ValidationLogic.validarRut(rutField);
    }
}