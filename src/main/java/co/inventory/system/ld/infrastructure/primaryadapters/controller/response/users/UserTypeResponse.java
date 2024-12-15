package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users;

import java.util.ArrayList;

import co.inventory.system.ld.application.primaryports.dto.users.UserTypeDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

public class UserTypeResponse extends Response<UserTypeDTO> {

	public UserTypeResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
