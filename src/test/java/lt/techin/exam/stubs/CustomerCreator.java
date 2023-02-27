package lt.techin.exam.stubs;

import lt.techin.exam.model.Customer;


public class CustomerCreator {

    public static Customer createCustomer(Long id) {
        var customer = new Customer();

        customer.setId(id);
        customer.setName("Customer");
        customer.setSurname("Surname");
        customer.setPhoneNumber(7678876L);
        customer.setLoyal(Boolean.FALSE);


        return customer;
    }
}
