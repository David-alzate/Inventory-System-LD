package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.inventory.system.ld.application.primaryports.dto.users.RegisterNewUserDTO;
import co.inventory.system.ld.application.primaryports.dto.users.UserDTO;
import co.inventory.system.ld.application.primaryports.interactor.users.GetUserInteractor;
import co.inventory.system.ld.application.primaryports.interactor.users.RegisterNewUserInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users.RegisterNewUserResponse;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users.UserResponse;

@RestController
@RequestMapping("/users/api/v1/user")
public class UserController {

	private final RegisterNewUserInteractor registerNewUserInteractor;
	private final GetUserInteractor getUserInteractor;

	public UserController(RegisterNewUserInteractor registerNewUserInteractor, GetUserInteractor getUserInteractor) {
		this.registerNewUserInteractor = registerNewUserInteractor;
		this.getUserInteractor = getUserInteractor;
	}

	@PostMapping
	public ResponseEntity<RegisterNewUserResponse> createUser(@RequestBody RegisterNewUserDTO user) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var userResponse = new RegisterNewUserResponse();

		try {
			registerNewUserInteractor.execute(user);
			userResponse.getMensajes().add("Usuario creado exitosamente");

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			userResponse.getMensajes().add(excepcion.getUserMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "se ha presentado un prblema tratando de registar el nuevo Usuario";
			userResponse.getMensajes().add(mensajeUsuario);

		}

		return new ResponseEntity<>(userResponse, httpStatusCode);

	}

	@GetMapping
	public ResponseEntity<UserResponse> getUsers() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var userResponse = new UserResponse();

		try {
			var userDTO = UserDTO.create();
			userResponse.setDatos(getUserInteractor.execute(userDTO));
			userResponse.getMensajes().add("Usuarios Consultados exitosamente");

		} catch (final InventorySystemException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			userResponse.getMensajes().add(excepcion.getMessage());
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de consultar los Usuarios";
			userResponse.getMensajes().add(mensajeUsuario);
		}

		return new ResponseEntity<>(userResponse, httpStatusCode);
	}
}
