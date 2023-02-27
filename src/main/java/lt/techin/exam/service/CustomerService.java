package lt.techin.exam.service;

import lt.techin.exam.dao.CustomerRepository;
import lt.techin.exam.dao.ItemRepository;
import lt.techin.exam.exception.ExamValidationException;
import lt.techin.exam.model.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    public CustomerService(CustomerRepository customerRepository, ItemRepository itemRepository) {
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer create(Customer post) {
        return customerRepository.save(post);
    }

//    public Customer update(Long id, Customer post) {
//        var existingPost = customerRepository.findById(id)
//                .orElseThrow(() -> new ExamValidationException("Post does not exist",
//                        "id", "Post not found", id.toString()));
//
//        existingPost.setTitle(post.getTitle());
//        existingPost.setText(post.getText());
//        return customerRepository.save(existingPost);
//    }
//
//    public boolean deleteById(Long id) {
//        try {
//            customerRepository.deleteById(id);
//            return true;
//        } catch (EmptyResultDataAccessException exception) {
//            return false;
//        }
//    }

}
