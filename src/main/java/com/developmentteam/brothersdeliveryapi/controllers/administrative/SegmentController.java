package com.developmentteam.brothersdeliveryapi.controllers.administrative;

import com.developmentteam.brothersdeliveryapi.dto.request.administrative.SegmentRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.segment.SegmentAllResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.segment.SegmentResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.segment.SegmentUpdateResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.developmentteam.brothersdeliveryapi.services.administrative.SegmentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/segments")
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SegmentAllResponse findById(@PathVariable Long id) {
        return segmentService.findById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public SegmentUpdateResponse updateSegment(@PathVariable Long id, @RequestBody @Valid SegmentRequest segmentRequest) {
        return segmentService.updateSegment(id, segmentRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSegment(@PathVariable Long id) {
        segmentService.deleteSegment(id);
    }
}
