package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.commons;

import co.inventory.system.ld.application.primaryports.dto.commons.GetIdTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.commons.GetIdTypeInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.commons.GetIdTypeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commons/api/v1/idType")
public class IdTypeController {

	private final GetIdTypeInteractor getIdTypeInteractor;

	public IdTypeController(final GetIdTypeInteractor getIdTypeInteractor) {
		this.getIdTypeInteractor = getIdTypeInteractor;
	}

	@GetMapping
	public ResponseEntity<GetIdTypeResponse> searchIdTypes() {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var getIdTypeResponse = new GetIdTypeResponse();

		try {
			var idTypeDTO = GetIdTypeDTO.create();
			getIdTypeResponse.setDatos(getIdTypeInteractor.execute(idTypeDTO));
			getIdTypeResponse.getMensajes().add("Se ha consultado los tipos de identificación exitosamente");

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			getIdTypeResponse.getMensajes().add(excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Ha ocurrido un error consultando los tipos de identificación";
			getIdTypeResponse.getMensajes().add(mensajeUsuario);
		}

		return new ResponseEntity<>(getIdTypeResponse, httpStatusCode);
	}
}
