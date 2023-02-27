package lt.techin.exam.api.dto.mapper;

import lt.techin.exam.api.dto.CustomerDto;
import lt.techin.exam.api.dto.CustomerEntityDto;
import lt.techin.exam.model.Customer;

public class CustomerMapper {

    public static CustomerDto toCustomerDto(Customer customer) {
        var customerDto = new CustomerDto();

        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setBirthday(customer.getBirthday());
        customerDto.setLoyal(customer.getLoyal());
        customerDto.setPhoneNumber(customer.getPhoneNumber());

        return customerDto;
    }

    public static CustomerEntityDto toCustomerEntityDto(Customer customer) {
        var customerDto = new CustomerEntityDto();

        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setBirthday(customer.getBirthday());
        customerDto.setLoyal(customer.getLoyal());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setCreatedDate(customer.getCreatedDate());

        return customerDto;
    }

    public static Customer toCustomer(CustomerDto customerDto) {
        var customer = new Customer();

        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setLoyal(customerDto.getLoyal());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setBirthday(customerDto.getBirthday());

        return customer;
    }

    public static Customer toCustomerFromEntityDto(CustomerEntityDto customerDto) {
        var customer = new Customer();

        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setBirthday(customerDto.getBirthday());
        customer.setLoyal(customerDto.getLoyal());
        customer.setPhoneNumber(customerDto.getPhoneNumber());


        return customer;
    }

}
