package co.inventory.system.ld.application.usecase.products.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.repository.products.ProductsRepository;
import co.inventory.system.ld.application.usecase.products.DeleteProduct;
import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.DeleteProductRulesValidator;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeleteProductImpl implements DeleteProduct {

	private final ProductsRepository productsRepository;
	private final DeleteProductRulesValidator deleteProductRulesValidator;

	public DeleteProductImpl(ProductsRepository productsRepository,
			DeleteProductRulesValidator deleteProductRulesValidator) {
		this.productsRepository = productsRepository;
		this.deleteProductRulesValidator = deleteProductRulesValidator;
	}

	@Override
	public void execute(UUID domain) {

		deleteProductRulesValidator.validate(domain);

		productsRepository.deleteById(domain);

	}

}
