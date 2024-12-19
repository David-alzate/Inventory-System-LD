package co.inventory.system.ld.application.usecase.customers.impl;

import co.inventory.system.ld.application.secondaryports.entity.customers.CustomerEntity;
import co.inventory.system.ld.application.secondaryports.mapper.commons.IdTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.customers.CustomerRepository;
import co.inventory.system.ld.application.usecase.customers.RegisterNewCustomer;
import co.inventory.system.ld.application.usecase.customers.rulesvalidator.RegisterNewCustomerRulesValidator;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCustomerImpl implements RegisterNewCustomer {
    private CustomerRepository customerRepository;
    private final RegisterNewCustomerRulesValidator registerNewCustomerRulesValidator;

    public RegisterNewCustomerImpl(RegisterNewCustomerRulesValidator registerNewCustomerRulesValidator, CustomerRepository customerRepository) {
        this.registerNewCustomerRulesValidator = registerNewCustomerRulesValidator;
        this.customerRepository = customerRepository;
    }

    @Override
    public void execute(CustomerDomain domain) {

        registerNewCustomerRulesValidator.validate(domain);

        var customerEntity = CustomerEntity.create().setId(domain.getId())
                .setName(domain.getName()).setLastName(domain.getLastName())
                .setIdType(IdTypeEntityMapper.INSTANCE.toEntity(domain.getIdType())).setIdNumber(domain.getIdNumber())
                .setEmail(domain.getEmail());

        customerRepository.save(customerEntity);
    }
}
