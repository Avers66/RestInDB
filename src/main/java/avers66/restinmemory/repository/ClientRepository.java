package avers66.restinmemory.repository;

import avers66.restinmemory.model.Client;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * ClientRepository
 *
 * @Author Tretyakov Alexandr
 */

public interface ClientRepository extends JpaRepository<Client, Long> {

    /**
     * @EntityGraph(attributePaths = {"orderList"}) будет загружать ордера при ленивой загрузке fetch=lazy
     * и при настройке spring.jpa.open-in-view = false и избежит проблемы N+1
     * @return
     */

    @Override
    @EntityGraph(attributePaths = {"orderList"})
    List<Client> findAll();
}
