package com.developmentteam.brothersdeliveryapi.controllers.administrative;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developmentteam.brothersdeliveryapi.services.administrative.SegmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/segments")
@RequiredArgsConstructor
public class SegmentController {
    
    private final SegmentService segmentService;

}
