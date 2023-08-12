package com.developmentteam.brothersdeliveryapi.services.administrative;

import com.developmentteam.brothersdeliveryapi.dto.request.administrative.StoreRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.StoreAllResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.StoreOrdersResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.StoreResponse;
import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;
import com.developmentteam.brothersdeliveryapi.repositories.orders.OrderRepository;
import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.repositories.administrative.StoreRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    
    private final StoreRepository storeRepository;

    private final OrderRepository orderRepository;

    public StoreResponse createStore(StoreRequest request) {
        Store store = Store.builder()
                .storeName(request.storeName())
                .storeDescription(request.storeDescription())
                .storeDeliveryStart(request.storeDeliveryStar())
                .storeDeliveryEnd(request.storeDeliveryEnd())
                .build();

        Store storeSaved = storeRepository.save(store);

        return StoreResponse.toResponse(storeSaved.getStoreName(),
                storeSaved.getStoreDescription(),
                storeSaved.getStoreDeliveryStart(),
                storeSaved.getStoreDeliveryEnd());
    }

    public List<StoreAllResponse> listAllStore() {
        return storeRepository.findAll().stream().map(StoreAllResponse::toResponse).toList();
    }

    public StoreAllResponse findById(Long id) {
        return storeRepository.findById(id).map(StoreAllResponse::toResponse).orElseThrow();
    }

    public List<StoreOrdersResponse> findOrdersById(Long id) {
        return orderRepository.findAllOrderByStoreId(id).stream().map(StoreOrdersResponse::toResponse).toList();
    }

}
