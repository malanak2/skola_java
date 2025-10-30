package cz.malanak.Services;

import cz.malanak.accounts.BaseAccount;
import cz.malanak.card.PaymentCard;
import cz.malanak.identification.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean deleteCustomer(Customer customer) {
        return customers.remove(customer);
    }

    public Customer getCustomerById(UUID customerId) {
        return customers.stream().filter(c -> customerId.equals(c.uuid)).findFirst().orElse(null);
    }
}
