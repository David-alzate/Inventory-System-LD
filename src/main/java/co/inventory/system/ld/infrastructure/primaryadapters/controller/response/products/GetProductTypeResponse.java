package co.inventory.system.ld.infrastructure.primaryadapters.controller.response.products;

import java.util.ArrayList;

import co.inventory.system.ld.application.primaryports.dto.products.ProductTypeDTO;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.Response;

public class GetProductTypeResponse extends Response<ProductTypeDTO> {

	public GetProductTypeResponse() {
		setMensajes(new ArrayList<String>());
		setDatos(new ArrayList<>());
	}

}
