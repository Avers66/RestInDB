package avers66.restinmemory.web.controller.v1;

import avers66.restinmemory.AbstractTestController;
import avers66.restinmemory.StringTestUtils;
import avers66.restinmemory.dto.ClientResponseDto;
import avers66.restinmemory.dto.ListClientResponseDto;
import avers66.restinmemory.dto.OrderResponseDto;
import avers66.restinmemory.mapper.v1.ClientMapper;
import avers66.restinmemory.model.Client;
import avers66.restinmemory.model.Order;
import avers66.restinmemory.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

/**
 * ClientControllerTest
 *
 * @Author Tretyakov Alexandr
 */

public class ClientControllerTest extends AbstractTestController {

    @MockBean
    ClientService clientService;

    @MockBean
    ClientMapper clientMapper;

    @Test
    public void whenFindAllThenReturnAllClients() throws Exception {
        List<Client> clients = new ArrayList<>();
        clients.add(createClient(1L, null ));
        Order order = createOrder(1L, 100L, null);
        clients.add(createClient(2L, order));
        List<ClientResponseDto> clientResponses = new ArrayList<>();
        clientResponses.add(createClientResponseDto(1L, null));
        OrderResponseDto orderResponse = createOrderResponseDto(1L, 100L);
        clientResponses.add(createClientResponseDto(2L, orderResponse));
        ListClientResponseDto listClientResponse = new ListClientResponseDto(clientResponses);

        Mockito.when(clientService.findAll()).thenReturn(clients);
        Mockito.when(clientMapper.listClientToListClientResponseDto(clients)).thenReturn(listClientResponse);

        String expectedResponse = StringTestUtils.readStringFromResource("response/find_all_clients_response.json");

        String actualResponse = mockMvc.perform(get("/api/v1/clients"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse))
                .andReturn()
                .getResponse()
                .getContentAsString();


//        System.out.println(expectedResponse);
//        System.out.println(actualResponse);
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);

        Mockito.verify(clientService, Mockito.times(1)).findAll();
        Mockito.verify(clientMapper, Mockito.times(1)).listClientToListClientResponseDto(clients);




    }
}
