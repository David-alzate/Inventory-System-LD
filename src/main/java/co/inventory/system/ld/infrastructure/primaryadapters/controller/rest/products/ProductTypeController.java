package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.inventory.system.ld.application.primaryports.dto.products.ProductTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.products.GetProductTypeInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.products.GetProductTypeResponse;

@RestController
@RequestMapping("/products/api/v1/productType")
public class ProductTypeController {

	private GetProductTypeInteractor getProductType;

	public ProductTypeController(GetProductTypeInteractor getProductType) {
		this.getProductType = getProductType;
	}

	@GetMapping
	public ResponseEntity<GetProductTypeResponse> getCustomers() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var productTypeResponse = new GetProductTypeResponse();

		try {
			var productTypeDTO = ProductTypeDTO.create();
			productTypeResponse.setDatos(getProductType.execute(productTypeDTO));
			productTypeResponse.getMensajes().add("Tipo de producto consultado correctamente");

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			productTypeResponse.getMensajes().add(excepcion.getMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var userMessage = "Error al consultar el tipo de producto";
			productTypeResponse.getMensajes().add(userMessage);
		}

		return new ResponseEntity<>(productTypeResponse, httpStatusCode);
	}

}
