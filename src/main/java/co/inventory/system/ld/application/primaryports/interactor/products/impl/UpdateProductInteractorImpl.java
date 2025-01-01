package co.inventory.system.ld.application.primaryports.interactor.products.impl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.UpdateProductInteractor;
import co.inventory.system.ld.application.primaryports.mapper.products.ProductDTOMapper;
import co.inventory.system.ld.application.usecase.products.UpdateProduct;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UpdateProductInteractorImpl implements UpdateProductInteractor {

	private final UpdateProduct updateProduct;

	public UpdateProductInteractorImpl(UpdateProduct updateProduct) {
		this.updateProduct = updateProduct;
	}

	@Override
	public void execute(ProductDTO data) {
		try {
			var productDomain = ProductDTOMapper.INSTANCE.toDomain(data);
			updateProduct.execute(productDomain);
		} catch (InventorySystemException exception) {
			throw exception;
		} catch (Exception exception) {
			var userMessage = "Se ha presentado un problema modificando el tipo de producto";
			var technicalMessage = "Se ha presentado un problema INESPERADO modificando el tipo de producto";

			throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);

		}

	}

}
