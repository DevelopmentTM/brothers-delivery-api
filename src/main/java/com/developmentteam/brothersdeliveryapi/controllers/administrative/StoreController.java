package com.developmentteam.brothersdeliveryapi.controllers.administrative;

import com.developmentteam.brothersdeliveryapi.dto.request.administrative.StoreRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.store.StoreAllResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.store.StoreOrdersResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.store.StoreResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.store.StoreUpdateResponse;
import com.developmentteam.brothersdeliveryapi.services.administrative.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StoreAllResponse findById(@PathVariable Long id) {
        return storeService.findById(id);
    }

    @GetMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<StoreOrdersResponse> findOrdersById(@PathVariable Long id) {
       return storeService.findOrdersById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public StoreUpdateResponse updateStore(@PathVariable Long id, @RequestBody @Valid StoreRequest storeRequest) {
        return storeService.updateStore(id, storeRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
    }
}
