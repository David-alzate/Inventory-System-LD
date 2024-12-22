package co.inventory.system.ld.application.secondaryports.entity.products;

import java.util.UUID;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productType")
public class ProductTypeEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "name")
	private String name;

	public ProductTypeEntity() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public ProductTypeEntity(UUID id, String name) {
		setId(id);
		setName(name);
	}

	public static final ProductTypeEntity create(UUID id, String name) {
		return new ProductTypeEntity(id, name);
	}

	public static final ProductTypeEntity create(UUID id) {
		return new ProductTypeEntity(id, TextHelper.EMPTY);
	}

	public static final ProductTypeEntity create() {
		return new ProductTypeEntity(UUIDHelper.getDefault(), TextHelper.EMPTY);
	}

	public UUID getId() {
		return id;
	}

	public ProductTypeEntity setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductTypeEntity setName(String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}

}
