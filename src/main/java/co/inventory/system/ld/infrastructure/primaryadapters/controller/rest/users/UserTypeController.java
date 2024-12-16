package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.inventory.system.ld.application.primaryports.dto.users.UserTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.users.GetUserTypeInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users.UserTypeResponse;

@RestController
@RequestMapping("/users/api/v1/userType")
public class UserTypeController {
	
	private final GetUserTypeInteractor getUserTypeInteractor;
	
	public UserTypeController(GetUserTypeInteractor getUserTypeInteractor) {
		this.getUserTypeInteractor = getUserTypeInteractor;
	}
	
	@GetMapping
	public ResponseEntity<UserTypeResponse> getUsers() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var userTypeResponse = new UserTypeResponse();

		try {
			var userTypeDTO = UserTypeDTO.create();
			userTypeResponse.setDatos(getUserTypeInteractor.execute(userTypeDTO));
			userTypeResponse.getMensajes().add("Tipos de usuarios Consultados exitosamente");

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			userTypeResponse.getMensajes().add(excepcion.getMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de consultar los tipos de usuarios";
			userTypeResponse.getMensajes().add(mensajeUsuario);
		}

		return new ResponseEntity<>(userTypeResponse, httpStatusCode);
	}

}
