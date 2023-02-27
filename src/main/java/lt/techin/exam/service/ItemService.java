package lt.techin.exam.service;

import lt.techin.exam.api.dto.ItemDto;
import lt.techin.exam.dao.ItemRepository;
import lt.techin.exam.dao.CustomerRepository;
import lt.techin.exam.exception.ExamValidationException;
import lt.techin.exam.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static lt.techin.exam.api.dto.mapper.ItemMapper.toItem;


@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final CustomerRepository customerRepository;


    public ItemService(ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    public List<Item> getAll(Long postId) {

        return itemRepository.findAllByCustomer_IdOrderByCreatedDateDesc(postId);
    }

    public Optional<Item> getById(Long id) {
        return itemRepository.findById(id);
    }


    public Item create(Long customerId, ItemDto itemDto) {
        var existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ExamValidationException("Customer does not exist",
                        "id", "Customer not found", customerId.toString()));
        itemDto.setCustomer(existingCustomer);

        return itemRepository.save(toItem(itemDto));
    }

//    public Comment update(Long id, Comment comment) {
//        comment.setId(id);
//        return itemRepository.save(comment);
//    }

    public boolean deleteById(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    private static final ExampleMatcher SEARCH_CONDITIONS_MATCH_ANY = ExampleMatcher
//            .matchingAny()
////            .withMatcher("date??", ExampleMatcher.GenericPropertyMatchers.exact())
//            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//            .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.exact())
//            .withIgnorePaths("id", "description",
//                    "createdDate", "modifiedDate", "createdBy", "modifiedBy");
//
//    private Pageable pageable(int page, int pageSize, String sortBy, Sort.Direction sortDirection) {
//        return PageRequest.of(page, pageSize, sortDirection, sortBy);
//    }
//
//    @Transactional(readOnly = true)
//    public Page<Comment> findByExample(String name, RoomType roomType, int page, int pageSize) {
//
//        Comment comment = new Comment();
//        if (name != null) {
//            comment.setName(name);
//        }
//        if (roomType != null) {
//            comment.setType(roomType);
//        }
//
//        Example<Comment> roomExample = Example.of(comment, SEARCH_CONDITIONS_MATCH_ANY);
//
//        Pageable pageable = PageRequest.of(page, pageSize);
//
//        return commentRepository.findAll(roomExample, pageable);
//    }
//
//    private static final ExampleMatcher SEARCH_CONDITIONS_MATCH_ANY = ExampleMatcher
//            .matchingAny()
//            .withMatcher("birthDate", ExampleMatcher.GenericPropertyMatchers.exact())
//            .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//            .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
//            .withIgnorePaths("employeeId", "gender", "hireDate", "salaries", "titles");
//


}
