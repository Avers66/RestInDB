package avers66.restinmemory.repository;

import avers66.restinmemory.model.Client;
import avers66.restinmemory.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * OrderRepository
 *
 * @Author Tretyakov Alexandr
 */

public interface OrderRepository extends JpaRepository<Order, Long> {

}
