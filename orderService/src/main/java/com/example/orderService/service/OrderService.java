package com.example.orderService.service;

import com.example.orderService.domain.Order;
import com.example.orderService.domain.OrderLineItems;
import com.example.orderService.dto.OrderLineItemsDto;
import com.example.orderService.dto.OrderRequest;
import com.example.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final DiscoveryClient discoveryClient;
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItemsList(orderRequest.getOrderLineItemsDtoList().stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto)).toList());
        boolean result = checkInventory(orderRequest.getOrderLineItemsDtoList().get(0).getSkuCode());
        log.info(String.valueOf(result));
        if (result) {
            orderRepository.save(order);
        } else {throw new IllegalArgumentException("Product currently is not available.");}
    }

    private boolean checkInventory(String skuCode){
//        List<ServiceInstance> instances = discoveryClient.getInstances("Inventory-service");
//        ServiceInstance serviceInstance = instances.get(0);
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/inventory/get/" + skuCode;
        String url = "http://Inventory-service/inventory/get/" + skuCode;
        return Boolean.TRUE.equals(webClientBuilder.build().get()
                .uri(url)
                        .retrieve()
                        .bodyToMono(Boolean.class)
                        .block());
        /* its should check quantity of product
        */
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }

}
