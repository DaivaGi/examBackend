//package lt.techin.exam.service;
//
//import lt.techin.exam.dao.PostRepository;
//import lt.techin.exam.exception.ZooValidationException;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static lt.techin.exam.stubs.AnimalCreator.createAnimal;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class PostServiceTest {
//
//    @Mock
//    PostRepository postRepository;
//
//    @InjectMocks
//    PostService postService;
//
//    @Test
//    void update_animalNotFound_throwsException() {
//        var animal = createAnimal(1l);
//
//        when(postRepository.findById(1l)).thenReturn(Optional.empty());
//
//        assertThatThrownBy(() -> postService.update(1l, animal))
//                .isInstanceOf(ZooValidationException.class)
//                .hasMessageContaining("Animal does not exist")
//                .hasFieldOrPropertyWithValue("rejectedValue", "1");
//    }
//
//}