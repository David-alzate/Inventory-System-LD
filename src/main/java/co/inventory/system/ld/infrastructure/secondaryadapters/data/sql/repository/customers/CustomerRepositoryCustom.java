package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.customers;

import co.inventory.system.ld.application.secondaryports.entity.customers.CustomerEntity;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<CustomerEntity> findByFilter (CustomerEntity filter);
}
