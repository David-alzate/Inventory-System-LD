package co.inventory.system.ld.domain.commons;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.Domain;

public class StatusDomain extends Domain{
	
	private String name;
	
	public StatusDomain(UUID id, String name) {
		super(id);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}
	

}
