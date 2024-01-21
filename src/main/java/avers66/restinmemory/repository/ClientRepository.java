package avers66.restinmemory.repository;

import avers66.restinmemory.model.Client;
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
}
