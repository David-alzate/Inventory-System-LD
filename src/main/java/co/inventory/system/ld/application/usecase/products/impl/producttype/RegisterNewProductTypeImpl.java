package co.inventory.system.ld.application.usecase.products.impl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductTypeEntity;
import co.inventory.system.ld.application.secondaryports.repository.products.ProductTypeRepository;
import co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.producttype.RegisterNewProductTypeRulesValidatorImpl;
import co.inventory.system.ld.application.usecase.products.producttype.RegisterNewProductType;
import co.inventory.system.ld.domain.products.ProductTypeDomain;

@Service
public class RegisterNewProductTypeImpl implements RegisterNewProductType {

	private final ProductTypeRepository productTypeRepository;
	private final RegisterNewProductTypeRulesValidatorImpl registerNewProductTypeRulesValidator;

	public RegisterNewProductTypeImpl(ProductTypeRepository productTypeRepository,
			RegisterNewProductTypeRulesValidatorImpl registerNewProductTypeRulesValidator) {
		this.productTypeRepository = productTypeRepository;
		this.registerNewProductTypeRulesValidator = registerNewProductTypeRulesValidator;
	}

	@Override
	public void execute(ProductTypeDomain domain) {

		registerNewProductTypeRulesValidator.validate(domain);

		var productTypeEntity = ProductTypeEntity.create().setId(domain.getId()).setName(domain.getName());

		productTypeRepository.save(productTypeEntity);

	}
}
