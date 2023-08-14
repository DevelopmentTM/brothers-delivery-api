package com.developmentteam.brothersdeliveryapi.dto.response.administrative.segment;

import java.io.Serializable;

public record SegmentResponse(

        String segmentName,
        String segmentDescription) implements Serializable {

    public static SegmentResponse toResponse(
            String segmentName,
            String segmentDescription) {

        return new SegmentResponse(
                segmentName,
                segmentDescription
        );
    }
}
