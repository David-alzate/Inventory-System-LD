package co.inventory.system.ld.domain;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

public class Domain {

	private UUID id;

	protected Domain(final UUID id) {
		setId(id);
	}

	public final UUID getId() {
		return id;
	}

	private final void setId(UUID id) {
		this.id = id;
	}

	public void generateId() {
		this.id = UUIDHelper.generate();
	}

}
