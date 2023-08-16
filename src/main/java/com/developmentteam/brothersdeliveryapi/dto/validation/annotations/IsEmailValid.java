package com.developmentteam.brothersdeliveryapi.dto.validation.annotations;

import com.developmentteam.brothersdeliveryapi.dto.validation.validator.IsEmailValidValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsEmailValidValidator.class)
public @interface IsEmailValid {




}
