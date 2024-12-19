package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.application.secondaryports.entity.customers.CustomerEntity;
import co.inventory.system.ld.application.secondaryports.repository.customers.CustomerRepository;
import co.inventory.system.ld.domain.customers.exceptions.CustomerEmailDoesExistsException;
import co.inventory.system.ld.domain.customers.rules.CustomerEmailDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public class CustomerEmailDoesNotExistsRuleImpl implements CustomerEmailDoesNotExistsRule {

    private final CustomerRepository customerRepository;

    public CustomerEmailDoesNotExistsRuleImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void validate(String data) {
        var customerFilter = CustomerEntity.create().setEmail(data);
        var results = customerRepository.findByFilter(customerFilter);

        if (!results.isEmpty()){
            throw CustomerEmailDoesExistsException.create();
        }
    }
}
