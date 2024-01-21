package avers66.restinmemory.mapper.v1;

import avers66.restinmemory.dto.ClientRequestDto;
import avers66.restinmemory.dto.ClientResponseDto;
import avers66.restinmemory.dto.ListClientResponseDto;
import avers66.restinmemory.model.Client;
import avers66.restinmemory.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClientMapper
 *
 * @Author Tretyakov Alexandr
 */

@Component
@RequiredArgsConstructor
public class ClientMapper {

    public final OrderMapper orderMapper;

    public Client requestToClient(ClientRequestDto requestDto) {
        Client client = new Client();
        client.setName(requestDto.getName());
        return client;
    }

    public Client requestToClient(Long clientId, ClientRequestDto requestDto) {
        Client client = requestToClient(requestDto);
        client.setId(clientId);
        return client;
    }

    public ClientResponseDto clientToResponse(Client client) {
        ClientResponseDto responseDto = new ClientResponseDto();
        responseDto.setName(client.getName());
        responseDto.setId(client.getId());
        responseDto.setOrders(orderMapper.listOrderToListOrderResponse(client.getOrderList()));
        return responseDto;
    }

//    public List<ClientResponseDto> listClientToListClientResponse(List<Client> clients) {
//        return clients.stream().map(this::clientToResponse).collect(Collectors.toList());
//    }

    public ListClientResponseDto listClientToListClientResponseDto(List<Client> clients) {
        ListClientResponseDto clientResponseDto = new ListClientResponseDto();
        clientResponseDto.setClients(clients.stream().map(this::clientToResponse).collect(Collectors.toList()));
        return clientResponseDto;
    }

}
