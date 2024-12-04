package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.commons;

import java.util.ArrayList;

import co.inventory.system.ld.application.primaryports.dto.commons.StatusDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

public class GetStatusResponse extends Response<StatusDTO> {

	public GetStatusResponse() {
		setMensajes(new ArrayList<String>());
		setDatos(new ArrayList<>());
	}

}
