package co.inventory.system.ld.application.primaryports.dto.users;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

public class UserTypeDTO {

	private UUID id;
	private String name;
	
	public UserTypeDTO() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public UserTypeDTO(final UUID id, final String name) {
		setId(id);
		setName(name);
	}
	
	public static final UserTypeDTO create(final UUID id, final String name) {
		return new UserTypeDTO(id, name);
	}
	
	public static final UserTypeDTO create() {
		return new UserTypeDTO();
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
