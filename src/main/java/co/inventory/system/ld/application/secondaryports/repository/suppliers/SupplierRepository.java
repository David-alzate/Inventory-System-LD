package co.inventory.system.ld.application.secondaryports.repository.suppliers;

import co.inventory.system.ld.application.secondaryports.entity.suppliers.SupplierEntity;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.suppliers.SupplierRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, UUID>, SupplierRepositoryCustom {
}
