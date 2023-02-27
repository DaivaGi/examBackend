//package lt.techin.exam.api;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lt.techin.exam.dao.CommentRepository;
//import lt.techin.exam.service.CommentService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.MockBeans;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest
//@MockBeans({@MockBean(CommentController.class), @MockBean(CommentService.class), @MockBean(CommentRepository.class)})
//@AutoConfigureMockMvc
//class PostControllerTest {
//
//    //@MockBean - tuos kuriuos norime izoliuoti nuo sio testo
//
////    @MockBean
////    AnimalRepository animalRepository;
//
//    @Autowired
//    ObjectMapper objectMapper;
//    @Autowired
//    MockMvc mockMvc;
//
//    @BeforeEach
//    public void setup() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//
//    @Test
//    void getAnimals_returnsCorrectDtos() throws Exception {
//        //operacija_kokiusduomenis_expectedresult
//
//        var animalDto1 = new AnimalEntityDto(1l, "zirafa", AnimalType.GIRAFFE, "", null);
//        var animalDto2 = new AnimalEntityDto(2l, "tigriukas", AnimalType.TIGER, "", null);
//        var animalDto3 = new AnimalEntityDto(3l, "liutukas", AnimalType.LION, null, null);
//        var animalDto4 = new AnimalEntityDto(4l, "registruotas zveris", AnimalType.PARROT, null, true);
//
//        var mvcResult = mockMvc.perform(
//                        MockMvcRequestBuilders
//                                .get("/api/v1/animals")
//                                .accept(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isOk())
//                .andReturn();
//
//        var mappedResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<AnimalEntityDto>>() {
//        });
//
//        assertThat(mappedResponse)
//                .containsExactlyInAnyOrder(animalDto1, animalDto2, animalDto3, animalDto4);
//
////        verify(animalRepository, times(1)).deleteNonRegisteredAnimals();
////        assertThat(mappedResponse)
////                .isEqualTo(expectedDtos);
//    }
//
//
////
////    @Test
////    void findMarkedAnimals() {
////    }
////
////    @Test
////    void getAnimal() {
////    }
////
////    @Test
////    void deleteAnimal() {
////    }
////
////    @Test
////    void createAnimal() {
////    }
////
////    @Test
////    void updateAnimal() {
////    }
//
//
//}