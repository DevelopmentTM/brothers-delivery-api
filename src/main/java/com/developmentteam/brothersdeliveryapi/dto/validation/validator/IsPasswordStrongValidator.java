package com.developmentteam.brothersdeliveryapi.dto.validation.validator;

import com.developmentteam.brothersdeliveryapi.dto.validation.annotations.IsPasswordStrong;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class IsPasswordStrongValidator implements ConstraintValidator<IsPasswordStrong, String> {
   @Override
   public void initialize(IsPasswordStrong constraintAnnotation) {
      ConstraintValidator.super.initialize(constraintAnnotation);
   }

   @Override
   public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
      return false;
   }
}
