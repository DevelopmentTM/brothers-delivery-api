package com.developmentteam.brothersdeliveryapi.dto.validation.annotations;

import com.developmentteam.brothersdeliveryapi.dto.validation.validator.IsEmailValidValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsEmailValidValidator.class)
public @interface IsEmailValid {

   String message() default "message default";

   String[] value() default {};

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};

}
