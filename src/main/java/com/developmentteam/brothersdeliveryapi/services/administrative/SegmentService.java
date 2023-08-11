package com.developmentteam.brothersdeliveryapi.services.administrative;

import com.developmentteam.brothersdeliveryapi.dto.request.administrative.SegmentRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.SegmentAllResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.SegmentResponse;
import com.developmentteam.brothersdeliveryapi.entities.administrative.Segment;
import com.developmentteam.brothersdeliveryapi.repositories.administrative.SegmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SegmentService {
    
    private final SegmentRepository segmentRepository;

    public SegmentResponse createSegment(SegmentRequest request) {
        Segment segment = Segment.builder()
                .segmentName(request.segmentName())
                .segmentDescription(request.segmentDescription())
                .build();

        Segment segmentSaved = segmentRepository.save(segment);

        return SegmentResponse.toResponse(segmentSaved.getSegmentName(),
                segmentSaved.getSegmentDescription());
    }

    public List<SegmentAllResponse> listAllSegment() {
        return segmentRepository.findAll().stream().map(SegmentAllResponse::toResponse).toList();
    }

}
