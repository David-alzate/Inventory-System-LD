package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.inventorymovements;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.RegisterNewInventoryMovementDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class RegisterNewInventoryMovementResponse extends Response<RegisterNewInventoryMovementDTO> {

    public RegisterNewInventoryMovementResponse() {
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
