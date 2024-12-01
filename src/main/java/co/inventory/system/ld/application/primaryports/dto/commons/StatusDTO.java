package co.inventory.system.ld.application.primaryports.dto.commons;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

public class StatusDTO {

	private UUID id;
	private String name;

	public StatusDTO() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public StatusDTO(final UUID id, final String name) {
		super();
		setId(id);
		setName(name);
	}

	public static StatusDTO create(final UUID id, final String name) {
		return new StatusDTO(id, name);
	}

	public static StatusDTO create() {
		return new StatusDTO();
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

}
