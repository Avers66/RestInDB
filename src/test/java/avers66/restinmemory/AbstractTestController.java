package avers66.restinmemory;

import avers66.restinmemory.dto.ClientResponseDto;
import avers66.restinmemory.dto.OrderResponseDto;
import avers66.restinmemory.mapper.v1.ClientMapper;
import avers66.restinmemory.model.Client;
import avers66.restinmemory.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * AbstractTestController
 *
 * @Author Tretyakov Alexandr
 */

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public abstract class AbstractTestController {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;


    protected Client createClient(Long id, Order order) {
        Client client= new  Client(id, "Client " + id, new ArrayList<>());
        if (order != null) {
            order.setClient(client);
            client.addOrder(order);
        }
        return client;

    }

    protected Order createOrder(Long id, Long cost, Client client ) {
       return  new Order(id, "Test product " + id, BigDecimal.valueOf(cost), Instant.now(), Instant.now(), client);
    }

    protected ClientResponseDto createClientResponseDto(Long id, OrderResponseDto orderResponse) {
        ClientResponseDto clientResponse = new ClientResponseDto(id, "Client " + id, new ArrayList<>());
        if (orderResponse != null) {
            clientResponse.getOrders().add(orderResponse);
        }
        return clientResponse;
    }

    protected OrderResponseDto createOrderResponseDto(Long id, Long cost ) {
        return new OrderResponseDto(id, "Test product " + id, BigDecimal.valueOf(cost));
    }

}
