package com.developmentteam.brothersdeliveryapi.services.administrative;

import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.repositories.administrative.SegmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SegmentService {
    
    private final SegmentRepository segmentRepository;

}
