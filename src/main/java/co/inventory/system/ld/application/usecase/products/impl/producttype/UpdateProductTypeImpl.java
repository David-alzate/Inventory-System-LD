package co.inventory.system.ld.application.usecase.products.impl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductTypeEntity;
import co.inventory.system.ld.application.secondaryports.repository.products.ProductTypeRepository;
import co.inventory.system.ld.application.usecase.products.producttype.UpdateProductType;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.producttype.UpdateProductTypeRulesValidator;
import co.inventory.system.ld.domain.products.ProductTypeDomain;

@Service
public class UpdateProductTypeImpl implements UpdateProductType {

	private final ProductTypeRepository productTypeRepository;
	private final UpdateProductTypeRulesValidator updateProductTypeRulesValidator;

	public UpdateProductTypeImpl(ProductTypeRepository productTypeRepository,
			UpdateProductTypeRulesValidator updateProductTypeRulesValidator) {
		this.productTypeRepository = productTypeRepository;
		this.updateProductTypeRulesValidator = updateProductTypeRulesValidator;
	}

	@Override
	public void execute(ProductTypeDomain domain) {

		updateProductTypeRulesValidator.validate(domain);

		var productTypeEntity = ProductTypeEntity.create().setId(domain.getId()).setName(domain.getName());

		productTypeRepository.save(productTypeEntity);

	}

}
