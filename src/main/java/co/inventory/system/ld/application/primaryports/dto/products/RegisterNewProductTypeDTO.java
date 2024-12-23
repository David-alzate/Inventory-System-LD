package co.inventory.system.ld.application.primaryports.dto.products;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;

public class RegisterNewProductTypeDTO {

	private String name;

	public RegisterNewProductTypeDTO() {
		setName(TextHelper.EMPTY);
	}

	public RegisterNewProductTypeDTO(String name) {
		setName(name);
	}

	public static final RegisterNewProductTypeDTO create(String name) {
		return new RegisterNewProductTypeDTO(name);
	}

	public static final RegisterNewProductTypeDTO create() {
		return new RegisterNewProductTypeDTO();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}

}
