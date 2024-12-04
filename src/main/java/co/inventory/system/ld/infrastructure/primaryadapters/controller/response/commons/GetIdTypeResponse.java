package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.commons;

import co.inventory.system.ld.application.primaryports.dto.commons.GetIdTypeDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class GetIdTypeResponse extends Response <GetIdTypeDTO> {

    public GetIdTypeResponse() {
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
