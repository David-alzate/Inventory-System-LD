package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.inventory.system.ld.application.primaryports.dto.products.ProductTypeDTO;
import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.GetProductTypeInteractor;
import co.inventory.system.ld.application.primaryports.interactor.products.RegisterNewProductTypeInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.products.ProductTypeResponse;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.products.RegisterNewProductTypeResponse;

@RestController
@RequestMapping("/products/api/v1/productType")
public class ProductTypeController {

	private GetProductTypeInteractor getProductType;
	private RegisterNewProductTypeInteractor registerNewProductTypeInteractor;

	public ProductTypeController(GetProductTypeInteractor getProductType,
			RegisterNewProductTypeInteractor registerNewProductTypeInteractor) {
		this.getProductType = getProductType;
		this.registerNewProductTypeInteractor = registerNewProductTypeInteractor;
	}

	@PostMapping
	public ResponseEntity<RegisterNewProductTypeResponse> create(@RequestBody RegisterNewProductTypeDTO product) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var productTypeResponse = new RegisterNewProductTypeResponse();

		try {
			registerNewProductTypeInteractor.execute(product);
			productTypeResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00072));

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			productTypeResponse.getMensajes().add(excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00069);
			productTypeResponse.getMensajes().add(userMessage);
		}

		return new ResponseEntity<>(productTypeResponse, httpStatusCode);
	}

	@GetMapping
	public ResponseEntity<ProductTypeResponse> getCustomers() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var productTypeResponse = new ProductTypeResponse();

		try {
			var productTypeDTO = ProductTypeDTO.create();
			productTypeResponse.setDatos(getProductType.execute(productTypeDTO));
			productTypeResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00073));

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			productTypeResponse.getMensajes().add(excepcion.getMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00071);
			productTypeResponse.getMensajes().add(userMessage);
		}

		return new ResponseEntity<>(productTypeResponse, httpStatusCode);
	}

}
