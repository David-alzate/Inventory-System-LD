package co.inventory.system.ld.application.usecase.products.impl.product;

import java.util.List;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.mapper.products.ProductEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.products.ProductsRepository;
import co.inventory.system.ld.application.usecase.products.product.GetProduct;
import co.inventory.system.ld.domain.products.ProductDomain;

@Service
public class GetProductImpl implements GetProduct {

	private ProductsRepository productsRepository;

	public GetProductImpl(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;

	}

	@Override
	public List<ProductDomain> execute(ProductDomain domain) {
		var productEntity = ProductEntityMapper.INSTANCE.toEntity(domain);
		var results = productsRepository.findByFilter(productEntity);
		return ProductEntityMapper.INSTANCE.toDomainCollection(results);
	}

}
