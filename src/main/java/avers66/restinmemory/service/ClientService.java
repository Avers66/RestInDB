package avers66.restinmemory.service;

import avers66.restinmemory.model.Client;

import java.util.List;
import java.util.Optional;

/**
 * ClientService
 *
 * @Author Tretyakov Alexandr
 */

public interface ClientService {

    List<Client> findAll();

   Client findById(Long id);

    Client save(Client client);

    Client update(Client client);

    void deleteById(Long id);
}