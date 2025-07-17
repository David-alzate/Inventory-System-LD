package co.inventory.system.ld.application.secondaryports.repository.sales;

import co.inventory.system.ld.application.secondaryports.entity.sales.SaleStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SaleStatusRepository extends JpaRepository<SaleStatusEntity, UUID> {
}
