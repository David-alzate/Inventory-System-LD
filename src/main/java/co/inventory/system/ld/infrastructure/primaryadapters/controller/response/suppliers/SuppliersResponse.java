package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.suppliers;

import co.inventory.system.ld.application.primaryports.dto.suppliers.SupplierDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class SuppliersResponse extends Response <SupplierDTO> {
    public SuppliersResponse() {
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
