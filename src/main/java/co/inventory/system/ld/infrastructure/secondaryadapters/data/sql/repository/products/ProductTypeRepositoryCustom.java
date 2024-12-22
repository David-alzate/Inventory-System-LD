package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.products;

import java.util.List;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductTypeEntity;


public interface ProductTypeRepositoryCustom {
	
	List<ProductTypeEntity> findByFilter(ProductTypeEntity filter);

}
