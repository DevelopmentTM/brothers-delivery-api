package com.developmentteam.brothersdeliveryapi.controllers.administrative;

import com.developmentteam.brothersdeliveryapi.dto.request.administrative.SegmentRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.SegmentAllResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.SegmentResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.developmentteam.brothersdeliveryapi.services.administrative.SegmentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/segments")
@RequiredArgsConstructor
public class SegmentController {
    
    private final SegmentService segmentService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public SegmentResponse createSegment(@RequestBody @Valid SegmentRequest segmentRequest) {
        return segmentService.createSegment(segmentRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<SegmentAllResponse> listAllSegment() {
        return segmentService.listAllSegment();
    }
}
