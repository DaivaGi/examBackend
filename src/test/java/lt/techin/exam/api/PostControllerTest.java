package lt.techin.exam.api;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.exam.api.dto.CustomerEntityDto;
import lt.techin.exam.dao.ItemRepository;
import lt.techin.exam.model.Customer;
import lt.techin.exam.service.ItemService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@MockBeans({@MockBean(ItemController.class), @MockBean(ItemService.class), @MockBean(ItemRepository.class)})
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setup() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getCustomer_returnsCorrectDtos() throws Exception {


        var customerDto1 = new CustomerEntityDto(1l, "Vardas", "Pavarde", "1980-02-15", 868677777, FALSE, "2023-02-15 00:36:54.344");
        var customerDto2 = new CustomerEntityDto(2l, "Vardas1", "Pavarde1", "1980-07-15", 868677778, FALSE, "2023-02-15 00:36:54.344");
        var customerDto3 = new CustomerEntityDto(3l, "Vardas2", "Pavarde2", "1980-02-19", 868677779, TRUE, "2023-02-15 00:36:54.344");
        var customerDto4 = new CustomerEntityDto(4l, "Vardas3", "Pavarde3", "1986-02-15", 868677770, FALSE, "2023-02-15 00:36:54.344");
        var customerDto5 = new CustomerEntityDto(5l, "Vardas4", "Pavarde4", "1988-07-11", 868677771, FALSE, "2023-02-15 00:36:54.344");

        var mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/customers")
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn();

        var mappedResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<CustomerEntityDto>>() {
        });

        assertThat(mappedResponse)
                .containsExactlyInAnyOrder(customerDto1, customerDto2, customerDto3, customerDto4, customerDto5);


    }
}