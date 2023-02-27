package lt.techin.exam.api;

import lt.techin.exam.api.dto.CustomerDto;
import lt.techin.exam.api.dto.CustomerEntityDto;
import lt.techin.exam.model.Customer;
import lt.techin.exam.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static lt.techin.exam.api.dto.mapper.CustomerMapper.toCustomer;
import static lt.techin.exam.api.dto.mapper.CustomerMapper.toCustomerEntityDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {

    public static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseBody
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerEntityDto> getCustomer(@PathVariable Long customerId) {
        var postOptional = customerService.getById(customerId);
        var responseEntity = postOptional
                .map(post -> ok(toCustomerEntityDto(post)))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<CustomerEntityDto> createCustomer(@RequestBody CustomerDto customerDto) {
        var createdPost = customerService.create(toCustomer(customerDto));

        return ok(toCustomerEntityDto(createdPost));
    }

}
