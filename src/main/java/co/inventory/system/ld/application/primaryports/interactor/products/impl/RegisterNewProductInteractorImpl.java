package co.inventory.system.ld.application.primaryports.interactor.products.impl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.RegisterNewProductInteractor;
import co.inventory.system.ld.application.primaryports.mapper.products.RegisterNewProductDTOMapper;
import co.inventory.system.ld.application.usecase.products.product.RegisterNewProduct;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegisterNewProductInteractorImpl implements RegisterNewProductInteractor {

	private final RegisterNewProduct registerNewProduct;

	public RegisterNewProductInteractorImpl(RegisterNewProduct registerNewProduct) {
		this.registerNewProduct = registerNewProduct;
	}

	@Override
	public void execute(RegisterNewProductDTO data) {
		try {
			var productDomain = RegisterNewProductDTOMapper.INSTANCE.toDomain(data);
			registerNewProduct.execute(productDomain);
		} catch (InventorySystemException exception) {
			throw exception;
		} catch (Exception exception) {
			var userMessage = "Se ha presentado un problema registrando el producto";
			var technicalMessage = "Se ha presentado un problema INESPERADO registrando el producto";

			throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);

		}

	}

}
