package co.inventory.system.ld.application.secondaryports.repository.products;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductEntity;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.products.ProductsRepositoryCustom;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, UUID>, ProductsRepositoryCustom {

}
