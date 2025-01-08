package co.inventory.system.ld.application.usecase.products.impl.producttype;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.repository.products.ProductTypeRepository;
import co.inventory.system.ld.application.usecase.products.producttype.DeleteProductType;

@Service
public class DeleteProductTypeImpl implements DeleteProductType {

	private final ProductTypeRepository productTypeRepository;

	public DeleteProductTypeImpl(ProductTypeRepository productTypeRepository) {
		this.productTypeRepository = productTypeRepository;
	}

	@Override
	public void execute(UUID domain) {
		productTypeRepository.deleteById(domain);

	}

}
