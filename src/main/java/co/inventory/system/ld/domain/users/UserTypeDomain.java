package co.inventory.system.ld.domain.users;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.Domain;

public class UserTypeDomain extends Domain {

	private String name;

	public UserTypeDomain(UUID id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}

}
