package co.inventory.system.ld.application.primaryports.interactor.customers;

import co.inventory.system.ld.application.primaryports.dto.customers.CustomerDTO;
import co.inventory.system.ld.application.primaryports.interactor.InteractorWithReturn;

import java.util.List;

public interface GetCustomerInteractor extends InteractorWithReturn <CustomerDTO, List<CustomerDTO>> {
}
