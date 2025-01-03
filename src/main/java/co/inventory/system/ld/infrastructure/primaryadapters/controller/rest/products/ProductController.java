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

import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.DeleteProductInteractor;
import co.inventory.system.ld.application.primaryports.interactor.products.GetProductInteractor;
import co.inventory.system.ld.application.primaryports.interactor.products.RegisterNewProductInteractor;
import co.inventory.system.ld.application.primaryports.interactor.products.UpdateProductInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.products.ProductResponse;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.products.RegisterNewProductResponse;

@RestController
@RequestMapping("/products/api/v1/product")
public class ProductController {

	private final RegisterNewProductInteractor registerNewProductInteractor;
	private final GetProductInteractor getProductInteractor;
	private final UpdateProductInteractor updateProductInteractor;
	private final DeleteProductInteractor deleteProductInteractor;

	public ProductController(RegisterNewProductInteractor registerNewProductInteractor,
			GetProductInteractor getProductInteractor, UpdateProductInteractor updateProductInteractor,
			DeleteProductInteractor deleteProductInteractor) {
		this.registerNewProductInteractor = registerNewProductInteractor;
		this.getProductInteractor = getProductInteractor;
		this.updateProductInteractor = updateProductInteractor;
		this.deleteProductInteractor = deleteProductInteractor;
	}

	@PostMapping
	public ResponseEntity<RegisterNewProductResponse> create(@RequestBody RegisterNewProductDTO product) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var productResponse = new RegisterNewProductResponse();

		try {
			registerNewProductInteractor.execute(product);
			productResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00083));

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			productResponse.getMensajes().add(excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00080);
			productResponse.getMensajes().add(userMessage);
		}

		return new ResponseEntity<>(productResponse, httpStatusCode);
	}

	@GetMapping
	public ResponseEntity<ProductResponse> getCustomers() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var productResponse = new ProductResponse();
		try {
			var productDTO = ProductDTO.create();
			productResponse.setDatos(getProductInteractor.execute(productDTO));
			productResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00084));

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			productResponse.getMensajes().add(excepcion.getMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00082);
			productResponse.getMensajes().add(userMessage);
		}

		return new ResponseEntity<>(productResponse, httpStatusCode);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductResponse> update(@PathVariable UUID id, @RequestBody ProductDTO productDTO) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var productResponse = new ProductResponse();

		try {
			productDTO.setId(id);
			updateProductInteractor.execute(productDTO);
			productResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00091));
		} catch (final InventorySystemException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			productResponse.getMensajes().add(exception.getUserMessage());
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00089);
			productResponse.getMensajes().add(mensajeUsuario);
		}
		return new ResponseEntity<>(productResponse, httpStatusCode);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ProductResponse> eliminar(@PathVariable UUID id) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var empleadoResponse = new ProductResponse();

		try {
			deleteProductInteractor.execute(id);
			empleadoResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00093));
		} catch (final InventorySystemException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			empleadoResponse.getMensajes().add(exception.getUserMessage());
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00092);
			empleadoResponse.getMensajes().add(mensajeUsuario);

		}
		return new ResponseEntity<>(empleadoResponse, httpStatusCode);
	}

}
