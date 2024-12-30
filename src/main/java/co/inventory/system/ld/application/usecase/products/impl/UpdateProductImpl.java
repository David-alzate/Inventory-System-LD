package co.inventory.system.ld.application.usecase.products.impl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductEntity;
import co.inventory.system.ld.application.secondaryports.mapper.products.ProductTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.suppliers.SupplierEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.products.ProductsRepository;
import co.inventory.system.ld.application.usecase.products.UpdateProduct;
import co.inventory.system.ld.domain.products.ProductDomain;

@Service
public class UpdateProductImpl implements UpdateProduct {

	private final ProductsRepository productsRepository;

	public UpdateProductImpl(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@Override
	public void execute(ProductDomain domain) {

		var productEntity = ProductEntity.create().setId(domain.getId()).setName(domain.getName())
				.setPrice(domain.getPrice())
				.setProductType(ProductTypeEntityMapper.INSTANCE.toEntity(domain.getProductType()))
				.setSupplier(SupplierEntityMapper.INSTANCE.toEntity(domain.getSupplier()));

		productsRepository.save(productEntity);

	}

}
