package co.inventory.system.ld.application.secondaryports.entity.commons;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class StatusEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "name")
	private String name;

	public StatusEntity() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public StatusEntity(final UUID id, final String name) {
		super();
		setId(id);
		setName(name);
	}

	public static StatusEntity create(final UUID id, final String name) {
		return new StatusEntity(id, name);
	}

	public static StatusEntity create(final UUID id) {
		return new StatusEntity(id, TextHelper.EMPTY);
	}

	public static StatusEntity create() {
		return new StatusEntity();
	}

	public UUID getId() {
		return id;
	}

	public StatusEntity setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}

	public String getName() {
		return name;
	}

	public StatusEntity setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}

}
