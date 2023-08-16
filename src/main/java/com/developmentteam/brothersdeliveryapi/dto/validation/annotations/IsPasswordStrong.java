package com.developmentteam.brothersdeliveryapi.dto.validation.annotations;

import com.developmentteam.brothersdeliveryapi.dto.validation.validator.IsPasswordStrongValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsPasswordStrongValidator.class)
public @interface IsPasswordStrong {


}
