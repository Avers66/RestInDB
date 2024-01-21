package avers66.restinmemory.web.controller.v1;
import avers66.restinmemory.StringTestUtils;
import avers66.restinmemory.dto.ClientRequestDto;
import avers66.restinmemory.dto.ClientResponseDto;
import avers66.restinmemory.dto.ListClientResponseDto;
import avers66.restinmemory.mapper.v1.ClientMapper;
import avers66.restinmemory.mapper.v1.OrderMapper;
import avers66.restinmemory.model.Client;
import avers66.restinmemory.model.Order;
import avers66.restinmemory.repository.ClientRepository;
import avers66.restinmemory.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * ClientControllerTestV2
 *
 * @Author Tretyakov Alexandr
 */

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClientControllerTestV2 {

        @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClientRepository repository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private OrderMapper orderMapper;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @Test
    public void whenFindAllThenReturnAllClients() throws Exception {
        Client client1 = new Client();
        client1.setName("Client 1");
        repository.save(client1);

        Client client2 = new Client();
        client2.setName("Client 2");
        repository.save(client2);

        Order order = new Order();
        order.setCost(new BigDecimal(100L));
        order.setProduct("Test product 1");
        order.setClient(client2);
        orderRepository.save(order);

        client2.addOrder(order);
        ListClientResponseDto responseDto  = clientMapper.listClientToListClientResponseDto(List.of(client1, client2));
        String expectedResponse = objectMapper.writeValueAsString(responseDto);

        String actualResponse = mockMvc.perform(get("/api/v1/clients"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json(expectedResponse))
                .andReturn()
                .getResponse()
                .getContentAsString();


//        System.out.println(expectedResponse);
//        System.out.println(actualResponse);
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//        Mockito.verify(repository, Mockito.times(1)).findAll();

    }

    @Test
    public void whenFindByIdThenReturnClient() throws Exception {
        Client client1 = new Client();
        client1.setName("Client 1");
        repository.save(client1);

        String endPoint = "/api/v1/clients/" + client1.getId().toString();

        Client client2 = new Client();
        client2.setName("Client 2");
        repository.save(client2);

        Order order = new Order();
        order.setCost(new BigDecimal(100L));
        order.setProduct("Test product 1");
        order.setClient(client2);
        orderRepository.save(order);

        client2.addOrder(order);
        ClientResponseDto responseDto = clientMapper.clientToResponse(client1);
        String expectedResponse = objectMapper.writeValueAsString(responseDto);

        String actualResponse = mockMvc.perform(get(endPoint))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json(expectedResponse))
                .andReturn()
                .getResponse()
                .getContentAsString();

//        System.out.println(expectedResponse);
//        System.out.println(actualResponse);
    }

    @Test
    public void whenSaveThenReturnClient() throws Exception {
        ClientRequestDto clientRequest = new ClientRequestDto("Client 1");

        String expectedResponse = objectMapper.writeValueAsString(clientRequest);

        String actualResponse = mockMvc.perform(post("/api/v1/clients")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(clientRequest)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(content().json(expectedResponse))
                .andReturn()
                .getResponse()
                .getContentAsString();

//        System.out.println(expectedResponse);
//        System.out.println(actualResponse);
    }

    @Test
    public void whenUpdateThenReturnClient() throws Exception {
        Client client1 = new Client();
        client1.setName("Client 1");
        repository.save(client1);

        String endPoint = "/api/v1/clients/" + client1.getId().toString();

        Client client2 = new Client();
        client2.setName("Client 2");
        repository.save(client2);

        Order order = new Order();
        order.setCost(new BigDecimal(100L));
        order.setProduct("Test product 1");
        order.setClient(client2);
        orderRepository.save(order);

        client2.addOrder(order);
        client1.setName("Client 12");
        ClientResponseDto responseDto = clientMapper.clientToResponse(client1);
        String expectedResponse = objectMapper.writeValueAsString(responseDto);


        String actualResponse = mockMvc.perform(put(endPoint)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"name\": \"Client 12\"}"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json(expectedResponse))
                .andReturn()
                .getResponse()
                .getContentAsString();

//        System.out.println(expectedResponse);
//        System.out.println(actualResponse);
    }

    @Test
    public void whenDeleteThenReturnClient() throws Exception {
        Client client1 = new Client();
        client1.setName("Client 1");
        repository.save(client1);

        String endPoint = "/api/v1/clients/" + client1.getId().toString();

        Client client2 = new Client();
        client2.setName("Client 2");
        repository.save(client2);

        Order order = new Order();
        order.setCost(new BigDecimal(100L));
        order.setProduct("Test product 1");
        order.setClient(client2);
        orderRepository.save(order);

        mockMvc.perform(delete(endPoint))
                .andExpect(status().isNoContent())
                .andDo(print());

    }

    @Test
    public void whenFindByIdNotExistThenReturnError() throws Exception {

        String expectedResponse = StringTestUtils.readStringFromResource("response/not_found_client_by_id.json");
        mockMvc.perform(get("/api/v1/clients/500"))
                .andExpect(status().isNotFound())
                .andExpect(content().json(expectedResponse))
                .andDo(print());



    }

    @Test
    public  void whenCreateClientWithoutName() throws Exception {
        String expectedResponse = StringTestUtils.readStringFromResource("response/empty_client_name_response.json");
        mockMvc.perform(post("/api/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new ClientRequestDto())))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedResponse))
                .andDo(print());

    }

    @Test
    public  void whenCreateClientWithSizeNameOut() throws Exception {
        String expectedResponse = StringTestUtils.readStringFromResource("response/client_name_size_exception_response.json");
        mockMvc.perform(post("/api/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new ClientRequestDto("C"))))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedResponse))
                .andDo(print());

    }

    @ParameterizedTest
    @MethodSource("invalidSizeName")
    public  void whenCreateClientWithSizeNameOut2(String name) throws Exception {
        String expectedResponse = StringTestUtils.readStringFromResource("response/client_name_size_exception_response.json");
        mockMvc.perform(post("/api/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new ClientRequestDto(name))))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedResponse))
                .andDo(print());

    }


    private static Stream<Arguments> invalidSizeName() {
        return Stream.of(Arguments.of(RandomString.make(2), Arguments.of(RandomString.make(31))));
    }



}
