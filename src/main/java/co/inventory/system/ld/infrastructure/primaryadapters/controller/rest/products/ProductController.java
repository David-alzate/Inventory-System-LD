package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.GetProductInteractor;
import co.inventory.system.ld.application.primaryports.interactor.products.RegisterNewProductInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.products.GetProductResponse;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.products.RegisterNewProductResponse;

@RestController
@RequestMapping("/products/api/v1/product")
public class ProductController {

	private final RegisterNewProductInteractor registerNewProductInteractor;
	private final GetProductInteractor getProductInteractor;

	public ProductController(RegisterNewProductInteractor registerNewProductInteractor,
			GetProductInteractor getProductInteractor) {
		this.registerNewProductInteractor = registerNewProductInteractor;
		this.getProductInteractor = getProductInteractor;
	}

	@PostMapping
	public ResponseEntity<RegisterNewProductResponse> create(@RequestBody RegisterNewProductDTO product) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var productResponse = new RegisterNewProductResponse();

		try {
			registerNewProductInteractor.execute(product);
			productResponse.getMensajes().add("Producto registrado correctamente");

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			productResponse.getMensajes().add(excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var userMessage = "Error al registrar el producto";
			productResponse.getMensajes().add(userMessage);
		}

		return new ResponseEntity<>(productResponse, httpStatusCode);
	}

	@GetMapping
	public ResponseEntity<GetProductResponse> getCustomers() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var productResponse = new GetProductResponse();
		try {
			var productDTO = ProductDTO.create();
			productResponse.setDatos(getProductInteractor.execute(productDTO));
			productResponse.getMensajes().add("Productos consultados correctamente");

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			productResponse.getMensajes().add(excepcion.getMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var userMessage = "Error al consultar los productos";
			productResponse.getMensajes().add(userMessage);
		}

		return new ResponseEntity<>(productResponse, httpStatusCode);
	}

}
