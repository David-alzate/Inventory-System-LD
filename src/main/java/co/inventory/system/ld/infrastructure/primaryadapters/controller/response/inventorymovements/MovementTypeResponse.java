package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.inventorymovements;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.MovementTypeDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class MovementTypeResponse extends Response<MovementTypeDTO> {

    public MovementTypeResponse() {
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
