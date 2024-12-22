package co.inventory.system.ld.application.primaryports.dto.products;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

public class ProductTypeDTO {

	private UUID id;
	private String name;

	public ProductTypeDTO() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public ProductTypeDTO(UUID id, String name) {
		setId(id);
		setName(name);
	}

	public static final ProductTypeDTO create(UUID id, String name) {
		return new ProductTypeDTO(id, name);
	}

	public static final ProductTypeDTO create() {
		return new ProductTypeDTO();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}

}
