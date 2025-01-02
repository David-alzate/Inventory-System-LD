package co.inventory.system.ld.application.usecase.products.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.repository.products.ProductsRepository;
import co.inventory.system.ld.application.usecase.products.DeleteProduct;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeleteProductImpl implements DeleteProduct {

	private final ProductsRepository productsRepository;

	public DeleteProductImpl(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@Override
	public void execute(UUID domain) {
		productsRepository.deleteById(domain);

	}

}
