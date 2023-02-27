//package lt.techin.exam.api;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lt.techin.exam.dao.PostRepository;
//import lt.techin.exam.dao.CommentRepository;
//import lt.techin.exam.service.CommentService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.MockBeans;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest
//@MockBeans({@MockBean(CommentController.class), @MockBean(CommentService.class), @MockBean(CommentRepository.class)})
//@AutoConfigureMockMvc
//class PostControllerNoDBTest {
//
//    @MockBean
//    PostRepository postRepository;
//
//    @Autowired
//    ObjectMapper objectMapper;
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    void updateAnimal_callsDbMethod() throws Exception {
//        when(postRepository.deleteNonRegisteredAnimals()).thenReturn(3);
//
//        var mvcResult = mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .post("/api/v1/animals/registry/clear")
//                )
//                .andExpect(status().isOk())
//                .andReturn();
//
//        var mappedResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Integer.class);
//
//        assertThat(mappedResponse)
//                .isEqualTo(3);
//    }
//
//}