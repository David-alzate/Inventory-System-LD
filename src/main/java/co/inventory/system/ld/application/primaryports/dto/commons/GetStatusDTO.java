package co.inventory.system.ld.application.primaryports.dto.commons;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

public class GetStatusDTO {

	private UUID id;
	private String name;

	public GetStatusDTO() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public GetStatusDTO(final UUID id, final String name) {
		super();
		setId(id);
		setName(name);
	}

	public static GetStatusDTO create(final UUID id, final String name) {
		return new GetStatusDTO(id, name);
	}

	public static GetStatusDTO create() {
		return new GetStatusDTO();
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
