package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.sales;

import co.inventory.system.ld.application.primaryports.dto.sales.SaleDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class SaleResponse extends Response<SaleDTO> {

    public SaleResponse() {
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }
}
