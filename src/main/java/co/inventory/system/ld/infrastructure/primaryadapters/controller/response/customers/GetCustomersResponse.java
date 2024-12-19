package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.customers;

import co.inventory.system.ld.application.primaryports.dto.customers.CustomerDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class GetCustomersResponse extends Response <CustomerDTO> {
    public GetCustomersResponse() {
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
