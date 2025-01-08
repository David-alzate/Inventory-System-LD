package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.products;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.inventory.system.ld.application.primaryports.dto.products.ProductTypeDTO;
import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.producttype.DeleteProductTypeInteractor;
import co.inventory.system.ld.application.primaryports.interactor.products.producttype.GetProductTypeInteractor;
import co.inventory.system.ld.application.primaryports.interactor.products.producttype.RegisterNewProductTypeInteractor;
import co.inventory.system.ld.application.primaryports.interactor.products.producttype.UpdateProductTypeInteractor;
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
	private UpdateProductTypeInteractor updateProductInteractor;
	private DeleteProductTypeInteractor deleteProductTypeInteractor;

	public ProductTypeController(GetProductTypeInteractor getProductType,
			RegisterNewProductTypeInteractor registerNewProductTypeInteractor,
			UpdateProductTypeInteractor updateProductInteractor, DeleteProductTypeInteractor deleteProductTypeInteractor) {
		this.getProductType = getProductType;
		this.registerNewProductTypeInteractor = registerNewProductTypeInteractor;
		this.updateProductInteractor = updateProductInteractor;
		this.deleteProductTypeInteractor = deleteProductTypeInteractor;
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

	@PutMapping("/{id}")
	public ResponseEntity<ProductTypeResponse> update(@PathVariable UUID id,
			@RequestBody ProductTypeDTO productTypeDTO) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var productTypeResponse = new ProductTypeResponse();

		try {
			productTypeDTO.setId(id);
			updateProductInteractor.execute(productTypeDTO);
			productTypeResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00096));
		} catch (final InventorySystemException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			productTypeResponse.getMensajes().add(exception.getUserMessage());
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00094);
			productTypeResponse.getMensajes().add(mensajeUsuario);
		}
		return new ResponseEntity<>(productTypeResponse, httpStatusCode);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ProductTypeResponse> eliminar(@PathVariable UUID id) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var productTypeResponse = new ProductTypeResponse();

		try {
			deleteProductTypeInteractor.execute(id);
			productTypeResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00098));
		} catch (final InventorySystemException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			productTypeResponse.getMensajes().add(exception.getUserMessage());
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00097);
			productTypeResponse.getMensajes().add(mensajeUsuario);

		}
		return new ResponseEntity<>(productTypeResponse, httpStatusCode);
	}

}
