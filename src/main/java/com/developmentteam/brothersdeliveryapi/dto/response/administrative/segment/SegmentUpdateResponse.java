package com.developmentteam.brothersdeliveryapi.dto.response.administrative.segment;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Segment;

import java.io.Serializable;

public record SegmentUpdateResponse(

        String segmentName,
        String segmentDescription) implements Serializable {

    public static SegmentUpdateResponse toResponse(Segment segment) {

        return new SegmentUpdateResponse(
                segment.getSegmentName(),
                segment.getSegmentDescription()
        );
    }
}
