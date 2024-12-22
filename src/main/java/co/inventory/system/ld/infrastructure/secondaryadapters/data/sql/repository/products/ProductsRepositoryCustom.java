package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.products;

import java.util.List;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductEntity;

public interface ProductsRepositoryCustom {

	List<ProductEntity> findByFilter(ProductEntity filter);

}
