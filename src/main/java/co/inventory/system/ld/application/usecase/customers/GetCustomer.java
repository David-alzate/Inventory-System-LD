package co.inventory.system.ld.application.usecase.customers;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.customers.CustomerDomain;

import java.util.List;

public interface GetCustomer extends UseCaseWithReturn <CustomerDomain, List<CustomerDomain>> {
}
