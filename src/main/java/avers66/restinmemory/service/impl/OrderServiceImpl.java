package avers66.restinmemory.service.impl;

import avers66.restinmemory.exception.EntityNotFoundException;
import avers66.restinmemory.model.Client;
import avers66.restinmemory.model.Order;
import avers66.restinmemory.repository.OrderRepository;
import avers66.restinmemory.service.OrderService;
import avers66.restinmemory.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

/**
 * OrderServiceImpl
 *
 * @Author Tretyakov Alexandr
 */


@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Ордер по Id {0} не найден", id)));
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        Order existOrder = findById(order.getId());
        BeanUtils.copyNonNullProperties(order, existOrder);
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteByIDS(List<Long> ids) {
        orderRepository.deleteAllById(ids);
    }
}
