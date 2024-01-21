package avers66.restinmemory.mapper.v1;

import avers66.restinmemory.dto.ListOrderResponseDto;
import avers66.restinmemory.dto.OrderRequestDto;
import avers66.restinmemory.dto.OrderResponseDto;
import avers66.restinmemory.model.Order;
import avers66.restinmemory.service.ClientService;
import avers66.restinmemory.service.impl.ClientServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderMapper
 *
 * @Author Tretyakov Alexandr
 */

@Component
@RequiredArgsConstructor
public class OrderMapper {


    private final ClientService clientService;

    public Order requestToOrder(OrderRequestDto orderRequest) {
        Order order = new Order();
        order.setProduct(orderRequest.getProduct());
        order.setCost(orderRequest.getCost());
        order.setClient(clientService.findById(orderRequest.getClientId()));
        return order;
    }

    public Order requestToOrder(Long orderId, OrderRequestDto orderRequest) {
        Order order = requestToOrder(orderRequest);
        order.setId(orderId);
        return order;
    }

    public OrderResponseDto orderToResponse(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setCost(order.getCost());
        orderResponseDto.setProduct(order.getProduct());
        orderResponseDto.setClientId(order.getClient().getId());
        return orderResponseDto;
    }

    public List<OrderResponseDto> listOrderToListOrderResponse(List<Order> orders) {
        return orders.stream().map(this::orderToResponse).collect(Collectors.toList());
    }

    public ListOrderResponseDto orderListToListOrderResponseDto(List<Order> orders) {
        ListOrderResponseDto listOrderResponseDto = new ListOrderResponseDto();
        listOrderResponseDto.setOrders(listOrderToListOrderResponse(orders));
        return listOrderResponseDto;
    }
}
