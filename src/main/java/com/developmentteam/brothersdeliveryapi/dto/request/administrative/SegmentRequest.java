package com.developmentteam.brothersdeliveryapi.dto.request.administrative;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SegmentRequest(

        @NotNull
        @NotBlank
        String segmentName,

        @NotNull
        @NotBlank
        String segmentDescription) {
}
