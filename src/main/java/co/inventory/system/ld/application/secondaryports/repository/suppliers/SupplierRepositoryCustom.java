package co.inventory.system.ld.application.secondaryports.repository.suppliers;

import co.inventory.system.ld.application.secondaryports.entity.suppliers.SupplierEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepositoryCustom {
    List<SupplierEntity> findByFilter(SupplierEntity filter);
}
