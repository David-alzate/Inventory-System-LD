package co.inventory.system.ld.application.secondaryports.repository.sales;

import co.inventory.system.ld.application.secondaryports.entity.sales.SaleProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProductEntity, UUID> {
}
