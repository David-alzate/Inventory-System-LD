package co.inventory.system.ld.domain.customers.rules.impl;

import co.inventory.system.ld.application.secondaryports.entity.customers.CustomerEntity;
import co.inventory.system.ld.application.secondaryports.repository.customers.CustomerRepository;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import co.inventory.system.ld.domain.customers.exceptions.CustomerIdNumberDoesExistsException;
import co.inventory.system.ld.domain.customers.rules.CustomerIdNumberDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public class CustomerIdNumberDoesNotExistsRuleImpl implements CustomerIdNumberDoesNotExistsRule {

    private final CustomerRepository customerRepository;

    public CustomerIdNumberDoesNotExistsRuleImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void validate(CustomerDomain data) {
        var customerFilter= CustomerEntity.create().setIdNumber(data.getIdNumber());
        var results= customerRepository.findByFilter(customerFilter);

        if (!results.isEmpty()) {
            throw CustomerIdNumberDoesExistsException.create();
        }
    }
}
