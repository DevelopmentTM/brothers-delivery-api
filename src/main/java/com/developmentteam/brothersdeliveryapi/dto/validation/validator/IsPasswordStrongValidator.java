package com.developmentteam.brothersdeliveryapi.dto.validation.validator;

import com.developmentteam.brothersdeliveryapi.dto.validation.annotations.IsPasswordStrong;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class IsPasswordStrongValidator implements ConstraintValidator<IsPasswordStrong, String> {

   public static final Pattern PASSWORD_PATTERN = Pattern
           .compile("\"^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$\"");

   @Override
   public void initialize(IsPasswordStrong constraintAnnotation) {
      ConstraintValidator.super.initialize(constraintAnnotation);
   }

   @Override
   public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
      if (password.isEmpty()) return false;
      return PASSWORD_PATTERN.matcher(password).matches();
   }
}
