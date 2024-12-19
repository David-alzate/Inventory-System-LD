package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.application.secondaryports.repository.customers.CustomerRepository;
import co.inventory.system.ld.domain.customers.exceptions.CustomerIdDoesExistsException;
import co.inventory.system.ld.domain.customers.rules.CustomerIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerIdDoesNotExistsRuleImpl implements CustomerIdDoesNotExistsRule {

    private final CustomerRepository customerRepository;

    public CustomerIdDoesNotExistsRuleImpl(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;
   }
    @Override
    public void validate(UUID data) {
        if (customerRepository.existsById(data)) {
            throw CustomerIdDoesExistsException.create();
        }
    }
}
