package co.inventory.system.ld.application.primaryports.interactor.products.impl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.producttype.RegisterNewProductTypeInteractor;
import co.inventory.system.ld.application.primaryports.mapper.products.RegisterNewProductTypeDTOMapper;
import co.inventory.system.ld.application.usecase.products.producttype.RegisterNewProductType;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
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
			var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00069);
			var technicalMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00070);

			throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);

		}

	}

}
