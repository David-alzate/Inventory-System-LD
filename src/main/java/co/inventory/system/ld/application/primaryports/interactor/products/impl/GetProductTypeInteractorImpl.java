package co.inventory.system.ld.application.primaryports.interactor.products.impl;

import java.util.List;

import co.inventory.system.ld.application.primaryports.dto.products.ProductTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.GetProductTypeInteractor;
import co.inventory.system.ld.application.primaryports.mapper.products.ProductTypeDTOMapper;
import co.inventory.system.ld.application.usecase.products.GetProductType;

public class GetProductTypeInteractorImpl implements GetProductTypeInteractor {
	
	private final GetProductType getProductType;
	
	public GetProductTypeInteractorImpl(GetProductType getProductType) {
		this.getProductType = getProductType;
	}

	@Override
	public List<ProductTypeDTO> execute(ProductTypeDTO data) {
		var productTypeDomain = ProductTypeDTOMapper.INSTANCE.toDomain(data);
		var results = getProductType.execute(productTypeDomain);
		return ProductTypeDTOMapper.INSTANCE.toDTOCollection(results);
	}

}
