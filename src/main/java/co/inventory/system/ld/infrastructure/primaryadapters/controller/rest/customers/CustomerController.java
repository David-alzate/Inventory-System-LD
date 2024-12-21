package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.customers;

import co.inventory.system.ld.application.primaryports.dto.customers.CustomerDTO;
import co.inventory.system.ld.application.primaryports.dto.customers.RegisterNewCustomerDTO;
import co.inventory.system.ld.application.primaryports.interactor.customers.GetCustomerInteractor;
import co.inventory.system.ld.application.primaryports.interactor.customers.RegisterNewCustomerInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.customers.GetCustomersResponse;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.customers.RegisterNewCustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers/api/v1/customer")
public class CustomerController {
	private final RegisterNewCustomerInteractor registerNewCustomerInteractor;
	private final GetCustomerInteractor getCustomerInteractor;

	public CustomerController(RegisterNewCustomerInteractor registerNewCustomerInteractor,
			GetCustomerInteractor getCustomerInteractor) {
		this.registerNewCustomerInteractor = registerNewCustomerInteractor;
		this.getCustomerInteractor = getCustomerInteractor;
	}

	@PostMapping
	public ResponseEntity<RegisterNewCustomerResponse> create(@RequestBody RegisterNewCustomerDTO customer) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var customerResponse = new RegisterNewCustomerResponse();

		try {
			registerNewCustomerInteractor.execute(customer);
			customerResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00059));

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			customerResponse.getMensajes().add(excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00056);
			customerResponse.getMensajes().add(userMessage);
		}

		return new ResponseEntity<>(customerResponse, httpStatusCode);
	}

	@GetMapping
	public ResponseEntity<GetCustomersResponse> getCustomers() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var customersResponse = new GetCustomersResponse();

		try {
			var customerDTO = CustomerDTO.create();
			customersResponse.setDatos(getCustomerInteractor.execute(customerDTO));
			customersResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00060));

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			customersResponse.getMensajes().add(excepcion.getMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00058);
			customersResponse.getMensajes().add(userMessage);
		}

		return new ResponseEntity<>(customersResponse, httpStatusCode);
	}
}
