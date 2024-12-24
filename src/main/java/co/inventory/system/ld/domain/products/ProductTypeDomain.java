package co.inventory.system.ld.domain.products;

import java.util.UUID;

import co.inventory.system.ld.domain.Domain;

public class ProductTypeDomain extends Domain {

	private String name;

	public ProductTypeDomain(UUID id, String name) {
		super(id);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
