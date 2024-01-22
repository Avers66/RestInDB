package avers66.restinmemory.repository;

import avers66.restinmemory.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * OrderRepository
 *
 * @Author Tretyakov Alexandr
 */

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    Page<Order> findAllByProduct(String product, Pageable pageable);

    //JPQL
//    @Query("SELECT o FROM  avers66.restinmemory.model.Order  o WHERE o.product = :productName")
//    List<Order> getAllByProductJPQL(String productName);

    //SQL
    @Query(nativeQuery = true, value = "SELECT * FROM  avers66.restinmemory.model.Order o WHERE o.product = :productName")
    List<Order> getAllByProductSQL(String productName);

}
