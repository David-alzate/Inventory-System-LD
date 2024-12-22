package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.customers;

import co.inventory.system.ld.application.primaryports.dto.customers.RegisterNewCustomerDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class RegisterNewCustomerResponse extends Response<RegisterNewCustomerDTO> {
	
    public RegisterNewCustomerResponse() {
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
