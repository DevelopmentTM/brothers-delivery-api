package com.developmentteam.brothersdeliveryapi.dto.validation.validator;

import com.developmentteam.brothersdeliveryapi.dto.validation.annotations.IsEmailValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class IsEmailValidValidator implements ConstraintValidator<IsEmailValid, String> {


   @Override
   public void initialize(IsEmailValid constraintAnnotation) {
      ConstraintValidator.super.initialize(constraintAnnotation);
   }

   @Override
   public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

      return false;
   }
}
