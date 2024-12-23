package co.inventory.system.ld.application.usecase.products.impl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductEntity;
import co.inventory.system.ld.application.secondaryports.mapper.products.ProductTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.mapper.suppliers.SupplierEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.products.ProductsRepository;
import co.inventory.system.ld.application.usecase.products.product.RegisterNewProduct;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;

@Service
public class RegisterNewProductImpl implements RegisterNewProduct {

	private final RegisterNewProductRulesValidator registerNewProductRulesValidator;
	private final ProductsRepository productsRepository;

	public RegisterNewProductImpl(RegisterNewProductRulesValidator registerNewProductRulesValidator,
			ProductsRepository productsRepository) {
		this.registerNewProductRulesValidator = registerNewProductRulesValidator;
		this.productsRepository = productsRepository;
	}

	@Override
	public void execute(ProductDomain domain) {
		registerNewProductRulesValidator.validate(domain);

		var productEntity = ProductEntity.create().setId(domain.getId()).setName(domain.getName())
				.setPrice(domain.getPrice()).setStock(domain.getStock())
				.setProductType(ProductTypeEntityMapper.INSTANCE.toEntity(domain.getProductType()))
				.setSupplier(SupplierEntityMapper.INSTANCE.toEntity(domain.getSupplier()));

		productsRepository.save(productEntity);

	}

}
