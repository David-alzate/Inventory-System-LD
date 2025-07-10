package co.inventory.system.ld.application.secondaryports.repository.sales;

import co.inventory.system.ld.application.secondaryports.entity.sales.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, UUID> {
}
