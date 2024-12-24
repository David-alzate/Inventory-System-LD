package co.inventory.system.ld.application.primaryports.interactor.products.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.GetProductInteractor;
import co.inventory.system.ld.application.primaryports.mapper.products.ProductDTOMapper;
import co.inventory.system.ld.application.usecase.products.product.GetProduct;

@Service
public class GetProductInteractorImpl implements GetProductInteractor {

	private final GetProduct getProduct;

	public GetProductInteractorImpl(GetProduct getProduct) {
		this.getProduct = getProduct;
	}

	@Override
	public List<ProductDTO> execute(ProductDTO data) {
		var productDomain = ProductDTOMapper.INSTANCE.toDomain(data);
		var results = getProduct.execute(productDomain);
		return ProductDTOMapper.INSTANCE.toDTOCollection(results);
	}

}
