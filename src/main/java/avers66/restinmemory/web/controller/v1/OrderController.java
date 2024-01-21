package avers66.restinmemory.web.controller.v1;

import avers66.restinmemory.dto.ListOrderResponseDto;
import avers66.restinmemory.dto.OrderRequestDto;
import avers66.restinmemory.dto.OrderResponseDto;
import avers66.restinmemory.mapper.v1.OrderMapper;
import avers66.restinmemory.model.Order;
import avers66.restinmemory.repository.OrderRepository;
import avers66.restinmemory.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * OrderController
 *
 * @Author Tretyakov Alexandr
 */


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    public ResponseEntity<ListOrderResponseDto> findAll() {
        ListOrderResponseDto listOrderResponseDto = orderMapper.orderListToListOrderResponseDto(orderService.findAll());
        return ResponseEntity.ok(listOrderResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> findById(@PathVariable Long id) {
        OrderResponseDto OrderResponseDto = orderMapper.orderToResponse(orderService.findById(id));
        return ResponseEntity.ok(OrderResponseDto);
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> save(@RequestBody OrderRequestDto RequestDto) {
        Order order = orderService.save(orderMapper.requestToOrder(RequestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(orderMapper.orderToResponse(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDto> update(@PathVariable Long id, @RequestBody OrderRequestDto RequestDto) {
        Order order = orderService.update(orderMapper.requestToOrder(id, RequestDto));
        return ResponseEntity.ok(orderMapper.orderToResponse(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void deleteByIds(@RequestBody List<Long> ids) {
        orderService.deleteByIDS(ids);
    }
}
