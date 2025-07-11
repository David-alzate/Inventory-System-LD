package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.users;

import co.inventory.system.ld.application.primaryports.dto.users.RegisterNewUserDTO;
import co.inventory.system.ld.application.primaryports.interactor.users.RegisterNewUserInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users.AuthResponse;
import co.inventory.system.ld.infrastructure.secondaryadapters.auth.service.UserDetailServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/api/v1")
public class AuthController {

    private final UserDetailServiceImpl userDetailService;
    private final RegisterNewUserInteractor registerNewUserInteractor;


    public AuthController(UserDetailServiceImpl userDetailService, RegisterNewUserInteractor registerNewUserInteractor) {
        this.userDetailService = userDetailService;
        this.registerNewUserInteractor = registerNewUserInteractor;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody RegisterNewUserDTO registerNewUserDTO){
        HttpStatus httpStatusCode = HttpStatus.ACCEPTED;
        AuthResponse authResponse = new AuthResponse();

        try {
            authResponse = registerNewUserInteractor.execute(registerNewUserDTO);
            authResponse.getMessages().add("Usuario creado correctamente");
        }catch (InventorySystemException inventorySystemException){
            httpStatusCode = HttpStatus.BAD_REQUEST;
            authResponse.getMessages().add(inventorySystemException.getUserMessage());
            inventorySystemException.printStackTrace();
        }catch (Exception exception){
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            authResponse.getMessages().add("Error al crear el usuario");
            exception.printStackTrace();
        }
        return new ResponseEntity<>(authResponse, httpStatusCode);
    }
}
