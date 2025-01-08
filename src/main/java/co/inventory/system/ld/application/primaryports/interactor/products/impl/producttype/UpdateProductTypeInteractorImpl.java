package co.inventory.system.ld.application.primaryports.interactor.products.impl.producttype;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.products.ProductTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.producttype.UpdateProductTypeInteractor;
import co.inventory.system.ld.application.primaryports.mapper.products.ProductTypeDTOMapper;
import co.inventory.system.ld.application.usecase.products.producttype.UpdateProductType;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UpdateProductTypeInteractorImpl implements UpdateProductTypeInteractor {

	private final UpdateProductType updateProduct;

	public UpdateProductTypeInteractorImpl(UpdateProductType updateProduct) {
		this.updateProduct = updateProduct;
	}

	@Override
	public void execute(ProductTypeDTO data) {
		try {
			var productTypeDomain = ProductTypeDTOMapper.INSTANCE.toDomain(data);
			updateProduct.execute(productTypeDomain);
		} catch (InventorySystemException exception) {
			throw exception;
		} catch (Exception exception) {
			var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00094);
			var technicalMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00095);

			throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);

		}

	}

}
