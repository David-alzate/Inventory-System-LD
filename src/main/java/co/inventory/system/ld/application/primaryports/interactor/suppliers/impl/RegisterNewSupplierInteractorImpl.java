package co.inventory.system.ld.application.primaryports.interactor.suppliers.impl;

import co.inventory.system.ld.application.primaryports.dto.suppliers.RegisterNewSupplierDTO;
import co.inventory.system.ld.application.primaryports.interactor.suppliers.RegisterNewSupplierInteractor;
import co.inventory.system.ld.application.primaryports.mapper.suppliers.RegisterNewSupplierDTOMapper;
import co.inventory.system.ld.application.usecase.suppliers.RegisterNewSupplier;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterNewSupplierInteractorImpl implements RegisterNewSupplierInteractor {

	private final RegisterNewSupplier registerNewSupplier;

	public RegisterNewSupplierInteractorImpl(RegisterNewSupplier registerNewSupplier) {
		this.registerNewSupplier = registerNewSupplier;
	}

	@Override
	public void execute(RegisterNewSupplierDTO data) {
		try {
			var supplierDomain = RegisterNewSupplierDTOMapper.INSTANCE.toDomain(data);
			registerNewSupplier.execute(supplierDomain);
		} catch (InventorySystemException exception) {
			throw exception;
		} catch (Exception exception) {
			var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00037);
			var technicalMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00038);

			throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);
		}
	}
}
