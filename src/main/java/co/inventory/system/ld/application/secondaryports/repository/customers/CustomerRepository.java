package co.inventory.system.ld.application.secondaryports.repository.customers;

import co.inventory.system.ld.application.secondaryports.entity.customers.CustomerEntity;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.customers.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository <CustomerEntity, UUID>, CustomerRepositoryCustom {
}
