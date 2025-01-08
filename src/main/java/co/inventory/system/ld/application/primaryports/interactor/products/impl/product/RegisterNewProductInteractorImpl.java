package co.inventory.system.ld.application.primaryports.interactor.products.impl.product;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.product.RegisterNewProductInteractor;
import co.inventory.system.ld.application.primaryports.mapper.products.RegisterNewProductDTOMapper;
import co.inventory.system.ld.application.usecase.products.product.RegisterNewProduct;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
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
			var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00080);
			var technicalMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00081);

			throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);

		}

	}

}
