package co.inventory.system.ld.application.primaryports.interactor.customers.impl;

import co.inventory.system.ld.application.primaryports.dto.customers.RegisterNewCustomerDTO;
import co.inventory.system.ld.application.primaryports.interactor.customers.RegisterNewCustomerInteractor;
import co.inventory.system.ld.application.primaryports.mapper.customers.RegisterNewCustomerDTOMapper;
import co.inventory.system.ld.application.usecase.customers.RegisterNewCustomer;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterNewCustomerInteractorImpl implements RegisterNewCustomerInteractor {

    private final RegisterNewCustomer registerNewCustomer;

    public RegisterNewCustomerInteractorImpl(RegisterNewCustomer registerNewCustomer) {
        this.registerNewCustomer = registerNewCustomer;
    }

    @Override
    public void execute(RegisterNewCustomerDTO data) {

        try { var registerCustomerDomain= RegisterNewCustomerDTOMapper.INSTANCE.toDomain(data);
            registerNewCustomer.execute(registerCustomerDomain);
        }catch (InventorySystemException exception){
            throw exception;
        }catch (Exception exception){
            var userMessage= "Se ha presentado un problema registrando el cliente";
            var technicalMessage="Se ha presentado un problema INESPERADO registrando el cliente";

            throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);
        }
    }
}
