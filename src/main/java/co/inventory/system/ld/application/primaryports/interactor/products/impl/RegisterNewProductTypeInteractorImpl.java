package co.inventory.system.ld.application.primaryports.interactor.products.impl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.RegisterNewProductTypeInteractor;
import co.inventory.system.ld.application.primaryports.mapper.products.RegisterNewProductTypeDTOMapper;
import co.inventory.system.ld.application.usecase.products.RegisterNewProductType;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegisterNewProductTypeInteractorImpl implements RegisterNewProductTypeInteractor {

	private final RegisterNewProductType registerNewProductType;

	public RegisterNewProductTypeInteractorImpl(RegisterNewProductType registerNewProductType) {
		this.registerNewProductType = registerNewProductType;
	}

	@Override
	public void execute(RegisterNewProductTypeDTO data) {
		try {
			var productDomain = RegisterNewProductTypeDTOMapper.INSTANCE.toDomain(data);
			registerNewProductType.execute(productDomain);
		} catch (InventorySystemException exception) {
			throw exception;
		} catch (Exception exception) {
			var userMessage = "Se ha presentado un problema registrando el tipo de producto";
			var technicalMessage = "Se ha presentado un problema INESPERADO registrando el tipo de producto";

			throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);

		}

	}

}
