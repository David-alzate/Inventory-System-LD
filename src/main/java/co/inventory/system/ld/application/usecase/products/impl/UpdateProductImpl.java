package co.inventory.system.ld.application.usecase.products.impl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductEntity;
import co.inventory.system.ld.application.secondaryports.mapper.products.ProductTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.suppliers.SupplierEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.products.ProductsRepository;
import co.inventory.system.ld.application.usecase.products.UpdateProduct;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.UpdateProductRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;

@Service
public class UpdateProductImpl implements UpdateProduct {

	private final ProductsRepository productsRepository;
	private final UpdateProductRulesValidator updateProductRulesValidator;

	public UpdateProductImpl(ProductsRepository productsRepository,
			UpdateProductRulesValidator updateProductRulesValidator) {
		this.productsRepository = productsRepository;
		this.updateProductRulesValidator = updateProductRulesValidator;
	}

	@Override
	public void execute(ProductDomain domain) {

		updateProductRulesValidator.validate(domain);

		var productEntity = ProductEntity.create().setId(domain.getId()).setName(domain.getName())
				.setPrice(domain.getPrice())
				.setProductType(ProductTypeEntityMapper.INSTANCE.toEntity(domain.getProductType()))
				.setSupplier(SupplierEntityMapper.INSTANCE.toEntity(domain.getSupplier()));

		productsRepository.save(productEntity);

	}

}
