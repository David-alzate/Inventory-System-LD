package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.products;

import java.util.ArrayList;

import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

public class GetProductResponse extends Response<ProductDTO> {

	public GetProductResponse() {
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<>());
    }

}
