package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.users;

import co.inventory.system.ld.application.primaryports.dto.users.RegisterNewUserDTO;
import co.inventory.system.ld.application.primaryports.interactor.users.RegisterNewUserInteractor;
import co.inventory.system.ld.crosscutting.exceptions.RuleInventorySystemException;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users.RegisterNewUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/api/v1/user")
public class UserController {

    private final RegisterNewUserInteractor registerNewUserInteractor;

    public UserController(RegisterNewUserInteractor registerNewUserInteractor) {
        this.registerNewUserInteractor = registerNewUserInteractor;
    }

    @PostMapping
    public ResponseEntity<RegisterNewUserResponse> registrarCiudad(@RequestBody RegisterNewUserDTO dto) {
        var httpStatusCode = HttpStatus.CREATED;
        var userResponse = new RegisterNewUserResponse();

        try {
            registerNewUserInteractor.execute(dto);
            userResponse.getMensajes().add("Usuario Registrado con exito");

        } catch (final RuleInventorySystemException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            userResponse.getMensajes().add(excepcion.getUserMessage());

        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un error registrando el usuario";
            userResponse.getMensajes().add(mensajeUsuario);
        }

        return new ResponseEntity<>(userResponse, httpStatusCode);
    }
}
