package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.suppliers;

import co.inventory.system.ld.application.primaryports.dto.suppliers.RegisterNewSupplierDTO;
import co.inventory.system.ld.application.primaryports.dto.suppliers.SupplierDTO;
import co.inventory.system.ld.application.primaryports.interactor.suppliers.GetSupplierInteractor;
import co.inventory.system.ld.application.primaryports.interactor.suppliers.RegisterNewSupplierInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.suppliers.GetSuppliersResponse;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.suppliers.RegisterNewSupplierResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers/api/v1/supplier")
public class SupplierController {

	private final RegisterNewSupplierInteractor registerNewSupplierInteractor;
	private final GetSupplierInteractor getSupplierInteractor;

	public SupplierController(RegisterNewSupplierInteractor registerNewSupplierInteractor,
			GetSupplierInteractor getSupplierInteractor) {
		this.registerNewSupplierInteractor = registerNewSupplierInteractor;
		this.getSupplierInteractor = getSupplierInteractor;
	}

	@PostMapping
	public ResponseEntity<RegisterNewSupplierResponse> create(@RequestBody RegisterNewSupplierDTO user) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var supplierResponse = new RegisterNewSupplierResponse();

		try {
			registerNewSupplierInteractor.execute(user);
			supplierResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00040));

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			supplierResponse.getMensajes().add(excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00037);
			supplierResponse.getMensajes().add(mensajeUsuario);

		}

		return new ResponseEntity<>(supplierResponse, httpStatusCode);

	}

	@GetMapping
	public ResponseEntity<GetSuppliersResponse> getSuppliers() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var suppliersResponse = new GetSuppliersResponse();

		try {
			var supplierDTO = SupplierDTO.create();
			suppliersResponse.setDatos(getSupplierInteractor.execute(supplierDTO));
			suppliersResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00041));

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			suppliersResponse.getMensajes().add(excepcion.getMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00039);
			suppliersResponse.getMensajes().add(mensajeUsuario);
		}

		return new ResponseEntity<>(suppliersResponse, httpStatusCode);
	}
}
