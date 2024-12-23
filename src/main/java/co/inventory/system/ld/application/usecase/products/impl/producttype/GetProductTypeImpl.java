package co.inventory.system.ld.application.usecase.products.impl.producttype;

import java.util.List;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.secondaryports.mapper.products.ProductTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.products.ProductTypeRepository;
import co.inventory.system.ld.application.usecase.products.producttype.GetProductType;
import co.inventory.system.ld.domain.products.ProductTypeDomain;

@Service
public class GetProductTypeImpl implements GetProductType{
	
	private ProductTypeRepository productTypeRepository;
	
	
	public GetProductTypeImpl(ProductTypeRepository productTypeRepository) {
		this.productTypeRepository = productTypeRepository;
	}


	@Override
	public List<ProductTypeDomain> execute(ProductTypeDomain domain) {
		var productTypeEntity = ProductTypeEntityMapper.INSTANCE.toEntity(domain);
		var results = productTypeRepository.findByFilter(productTypeEntity);
		return ProductTypeEntityMapper.INSTANCE.toDomainCollection(results);
	}

}
