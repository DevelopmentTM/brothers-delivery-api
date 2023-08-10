package com.developmentteam.brothersdeliveryapi.services.administrative;

import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.repositories.administrative.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {
    
    private final StoreRepository storeRepository;

}
