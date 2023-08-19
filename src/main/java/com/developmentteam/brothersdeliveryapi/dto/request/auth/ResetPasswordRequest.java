package com.developmentteam.brothersdeliveryapi.dto.request.auth;

import com.developmentteam.brothersdeliveryapi.dto.validation.annotations.IsPasswordStrong;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

public record ResetPasswordRequest(

        @NotBlank
        String resetToken,
        @NotBlank
        @IsPasswordStrong
        String password,
        @NotBlank
        @IsPasswordStrong
        String confirmPassword

) implements Serializable { }