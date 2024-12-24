package co.inventory.system.ld.application.secondaryports.repository.products;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductTypeEntity;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.products.ProductTypeRepositoryCustom;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, UUID>, ProductTypeRepositoryCustom{

}
