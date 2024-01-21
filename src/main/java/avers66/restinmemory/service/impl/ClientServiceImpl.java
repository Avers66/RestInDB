package avers66.restinmemory.service.impl;

import avers66.restinmemory.exception.EntityNotFoundException;
import avers66.restinmemory.model.Client;
import avers66.restinmemory.repository.ClientRepository;
import avers66.restinmemory.service.ClientService;
import avers66.restinmemory.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

/**
 * ClientServiceImpl
 *
 * @Author Tretyakov Alexandr
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Клиент с ID {0} не найден", id)));
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        Client existedClient = findById(client.getId());
        BeanUtils.copyNonNullProperties(client, existedClient );
        return clientRepository.save(existedClient);
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);

    }
}
