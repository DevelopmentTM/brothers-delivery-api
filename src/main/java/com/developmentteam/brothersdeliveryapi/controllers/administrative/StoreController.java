package com.developmentteam.brothersdeliveryapi.controllers.administrative;

import com.developmentteam.brothersdeliveryapi.dto.request.administrative.StoreRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.StoreAllResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.StoreResponse;
import com.developmentteam.brothersdeliveryapi.services.administrative.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {
    
    private final StoreService storeService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public StoreResponse createSegment(@RequestBody @Valid StoreRequest storeRequest) {
        return storeService.createStore(storeRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<StoreAllResponse> listAllStore() {
        return storeService.listAllStore();
    }
}
