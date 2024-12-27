package co.inventory.system.ld.domain.products.rules.impl.producttype;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.repository.products.ProductTypeRepository;
import co.inventory.system.ld.domain.products.exceptions.producttype.ProducTypeIdDoesNotExistException;
import co.inventory.system.ld.domain.products.rules.producttype.ProductTypeIdDoesExistsRule;

@Service
public class ProductTypeIdDoesExistsRuleImpl implements ProductTypeIdDoesExistsRule {

	private ProductTypeRepository productTypeRepository;

	public ProductTypeIdDoesExistsRuleImpl(ProductTypeRepository productTypeRepository) {
		super();
		this.productTypeRepository = productTypeRepository;
	}

	@Override
	public void validate(final UUID data) {
		if (!productTypeRepository.existsById(data)) {
			throw ProducTypeIdDoesNotExistException.create();
		}
	}
}
