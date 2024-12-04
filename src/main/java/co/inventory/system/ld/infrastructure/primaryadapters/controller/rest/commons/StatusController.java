package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.commons;

import co.inventory.system.ld.application.primaryports.dto.commons.StatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.inventory.system.ld.application.primaryports.interactor.commons.GetStatusInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.commons.GetStatusResponse;

@RestController
@RequestMapping("/commons/api/v1/status")
public class StatusController {

	private final GetStatusInteractor getStatusInteractor;

	public StatusController(GetStatusInteractor getStatusInteractor) {
		this.getStatusInteractor = getStatusInteractor;
	}

	@GetMapping
	public ResponseEntity<GetStatusResponse> searchIdTypes() {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var getStatuspeResponse = new GetStatusResponse();

		try {
			var statusDTO = StatusDTO.create();
			getStatuspeResponse.setDatos(getStatusInteractor.execute(statusDTO));
			getStatuspeResponse.getMensajes().add("Se ha consultado los estados exitosamente");

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			getStatuspeResponse.getMensajes().add(excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Ha ocurrido un error consultando los estados";
			getStatuspeResponse.getMensajes().add(mensajeUsuario);
		}

		return new ResponseEntity<>(getStatuspeResponse, httpStatusCode);
	}

}
