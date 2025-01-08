package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.inventorymovements;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.InventoryMovementDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class InventoryMovementResponse extends Response<InventoryMovementDTO> {

    public InventoryMovementResponse() {
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
