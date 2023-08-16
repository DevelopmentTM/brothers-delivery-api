package com.developmentteam.brothersdeliveryapi.services.administrative;

import com.developmentteam.brothersdeliveryapi.config.exceptions.custom.ResourceNotFoundException;
import com.developmentteam.brothersdeliveryapi.dto.request.administrative.StoreRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.store.*;
import com.developmentteam.brothersdeliveryapi.entities.administrative.Segment;
import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;
import com.developmentteam.brothersdeliveryapi.entities.orders.Order;
import com.developmentteam.brothersdeliveryapi.repositories.administrative.SegmentRepository;
import com.developmentteam.brothersdeliveryapi.repositories.orders.OrderRepository;
import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.repositories.administrative.StoreRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {
    
    private final StoreRepository storeRepository;

    private final OrderRepository orderRepository;
    private final SegmentRepository segmentRepository;

    public StoreResponse createStore(StoreRequest request) {

        Segment segment = segmentRepository.findById(request.storeSegmentId())
                .orElseThrow(() -> new ResourceNotFoundException("storeSegmentId não encontrado"));
        
        Store store = Store.builder()
                .storeName(request.storeName())
                .storeDescription(request.storeDescription())
                .storeDeliveryStart(request.storeDeliveryStart())
                .storeDeliveryEnd(request.storeDeliveryEnd())
                .storeSegment(segment)
                .build();

        Store storeSaved = storeRepository.save(store);

        return StoreResponse.toResponse(storeSaved);
    }

    public List<StoreAllResponse> listAllStore() {
        return storeRepository.findAll().stream().map(StoreAllResponse::toResponse).toList();
    }

    public StoreAllResponse findById(Long id) {
        return storeRepository.findById(id).map(StoreAllResponse::toResponse).orElseThrow();
    }

    public StoreUpdateResponse updateStore(Long id, StoreRequest request) {

        Segment segment = segmentRepository.findById(request.storeSegmentId())
                .orElseThrow(() -> new ResourceNotFoundException("storeSegmentId não encontrado"));

        return storeRepository.findById(id)
                .map(store -> {
                    store.setStoreName(request.storeName());
                    store.setStoreDescription(request.storeDescription());
                    store.setStoreDeliveryStart(request.storeDeliveryStart());
                    store.setStoreDeliveryEnd(request.storeDeliveryEnd());
                    store.setStoreSegment(segment);
                    return StoreUpdateResponse.toResponse(storeRepository.save(store));
                }).orElseThrow();
    }

    public List<StoreOrdersResponse> findOrdersById(Long storeId) {

        List<Order> orderForStore = orderRepository.findAllOrderByStoreId(storeId);

        return orderForStore.stream().map(StoreOrdersResponse::toResponse).toList();
    }

    public List<StoreProductsResponse> findProductsById(Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow();

        return store.getStoreProducts().stream().map(StoreProductsResponse::toResponse).toList();
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

}
