package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users;

import co.inventory.system.ld.application.primaryports.dto.users.RegisterNewUserDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class RegisterNewUserResponse extends Response<RegisterNewUserDTO> {

    public RegisterNewUserResponse() {
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
