package avers66.restinmemory.service;

import avers66.restinmemory.model.Order;

import java.util.List;
import java.util.Optional;

/**
 * OrderService
 *
 * @Author Tretyakov Alexandr
 */

public interface OrderService {
    List<Order> findAll();

    Order findById(Long id);

    Order save(Order order);

    Order update(Order order);

    void deleteById(Long id);

    void deleteByIDS(List<Long> ids);
}
