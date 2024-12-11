package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.suppliers;

import co.inventory.system.ld.application.primaryports.dto.suppliers.RegisterNewSupplierDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class RegisterNewSupplierResponse extends Response<RegisterNewSupplierDTO> {

    public RegisterNewSupplierResponse() {
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
