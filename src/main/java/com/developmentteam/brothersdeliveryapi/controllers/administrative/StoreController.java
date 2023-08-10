package com.developmentteam.brothersdeliveryapi.controllers.administrative;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developmentteam.brothersdeliveryapi.services.administrative.StoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {
    
    private final StoreService storeService;

}
