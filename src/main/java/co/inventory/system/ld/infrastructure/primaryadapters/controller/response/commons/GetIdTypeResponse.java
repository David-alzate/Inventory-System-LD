package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.commons;

import co.inventory.system.ld.application.primaryports.dto.commons.IdTypeDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class GetIdTypeResponse extends Response <IdTypeDTO> {

    public GetIdTypeResponse() {
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
