package com.developmentteam.brothersdeliveryapi.dto.validation.validator;

import com.developmentteam.brothersdeliveryapi.dto.validation.annotations.IsEmailValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class IsEmailValidValidator implements ConstraintValidator<IsEmailValid, String> {

   public static final Pattern EMAIL_PATTERN = Pattern
           .compile("\"^[\\\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$\"");

   @Override
   public void initialize(IsEmailValid constraintAnnotation) {
      ConstraintValidator.super.initialize(constraintAnnotation);
   }

   @Override
   public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
      if (email.isEmpty()) return false;
      return EMAIL_PATTERN.matcher(email).matches();
   }
}
