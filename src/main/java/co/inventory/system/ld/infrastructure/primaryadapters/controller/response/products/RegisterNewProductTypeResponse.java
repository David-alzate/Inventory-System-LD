package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.products;

import java.util.ArrayList;

import co.inventory.system.ld.application.primaryports.dto.products.RegisterNewProductTypeDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

public class RegisterNewProductTypeResponse extends Response<RegisterNewProductTypeDTO>{
	
    public RegisterNewProductTypeResponse() {
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }

}
