package com.developmentteam.brothersdeliveryapi.services.administrative;

import com.developmentteam.brothersdeliveryapi.dto.request.administrative.StoreRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.administrative.store.*;
import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;
import com.developmentteam.brothersdeliveryapi.entities.orders.Order;
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

    public StoreResponse createStore(StoreRequest request) {
        Store store = Store.builder()
                .storeName(request.storeName())
                .storeDescription(request.storeDescription())
                .storeDeliveryStart(request.storeDeliveryStart())
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

    public StoreUpdateResponse updateStore(Long id, StoreRequest request) {
        return storeRepository.findById(id)
                .map(store -> {
                    store.setStoreName(request.storeName());
                    store.setStoreDescription(request.storeDescription());
                    store.setStoreDeliveryStart(request.storeDeliveryStart());
                    store.setStoreDeliveryEnd(request.storeDeliveryEnd());
                    return StoreUpdateResponse.toResponse(storeRepository.save(store));
                }).orElseThrow();
    }

//    Refazer
    public List<StoreOrdersResponse> findOrdersById(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        Long storeOrderId = store.get().getStoreOrders().stream().map(Order::getOrderId).count();

        return orderRepository.findAllOrderByStoreId(storeOrderId).stream().map(StoreOrdersResponse::toResponse).toList();
    }

    public List<StoreProductsResponse> findProductsById(Long id) {
        return null;
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

}
