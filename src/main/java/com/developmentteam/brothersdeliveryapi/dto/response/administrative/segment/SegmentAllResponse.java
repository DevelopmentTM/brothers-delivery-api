package com.developmentteam.brothersdeliveryapi.dto.response.administrative.segment;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Segment;

import java.io.Serializable;

public record SegmentAllResponse(

        Long segmentId,

        String segmentName,

        String segmentDescription) implements Serializable {

    public static SegmentAllResponse toResponse(Segment segment) {

        return new SegmentAllResponse(
                segment.getSegmentId(),
                segment.getSegmentName(),
                segment.getSegmentDescription()
        );
    }

}
