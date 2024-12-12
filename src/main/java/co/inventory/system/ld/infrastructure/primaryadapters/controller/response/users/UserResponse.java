package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users;

import java.util.ArrayList;

import co.inventory.system.ld.application.primaryports.dto.users.UserDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

public class UserResponse extends Response<UserDTO> {

	public UserResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}