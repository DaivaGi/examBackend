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
    public boolean deleteById(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
