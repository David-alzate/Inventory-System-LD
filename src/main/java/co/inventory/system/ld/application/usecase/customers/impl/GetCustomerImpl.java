package co.inventory.system.ld.application.usecase.customers.impl;

import co.inventory.system.ld.application.secondaryports.mapper.customers.CustomerEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.customers.CustomerRepository;
import co.inventory.system.ld.application.usecase.customers.GetCustomer;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomerImpl implements GetCustomer {

    private CustomerRepository customerRepository;
    public GetCustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<CustomerDomain> execute(CustomerDomain domain) {
        var customerEntity= CustomerEntityMapper.INSTANCE.toEntity(domain);
        var results= customerRepository.findByFilter(customerEntity);
        return CustomerEntityMapper.INSTANCE.toDomainCollection(results);
    }
}
