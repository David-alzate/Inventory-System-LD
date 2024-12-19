package co.inventory.system.ld.application.primaryports.interactor.customers.impl;

import co.inventory.system.ld.application.primaryports.dto.customers.CustomerDTO;
import co.inventory.system.ld.application.primaryports.interactor.customers.GetCustomerInteractor;
import co.inventory.system.ld.application.primaryports.mapper.customers.CustomerDTOMapper;
import co.inventory.system.ld.application.usecase.customers.GetCustomer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GetCustomerInteractorImpl implements GetCustomerInteractor {

    private final GetCustomer getCustomer;

    public GetCustomerInteractorImpl(GetCustomer getCustomer) {
        this.getCustomer = getCustomer;
    }

    @Override
    public List<CustomerDTO> execute(CustomerDTO data) {
        var customerDomain= CustomerDTOMapper.INSTANCE.toDomain(data);
        var results= getCustomer.execute(customerDomain);
        return CustomerDTOMapper.INSTANCE.toDTOCollection(results);
    }
}
