package co.inventory.system.ld.application.secondaryports.entity.products;

import java.math.BigDecimal;
import java.util.UUID;

import co.inventory.system.ld.application.secondaryports.entity.suppliers.SupplierEntity;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "productType")
	private ProductTypeEntity productType;

	@ManyToOne
	@JoinColumn(name = "supplier")
	private SupplierEntity supplier;

	public ProductEntity() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setPrice(BigDecimal.ZERO);
		setProductType(ProductTypeEntity.create());
		setSupplier(SupplierEntity.create());
	}

	public ProductEntity(UUID id, String name, BigDecimal price, ProductTypeEntity productType,
			SupplierEntity supplier) {
		setId(id);
		setName(name);
		setPrice(price);
		setProductType(productType);
		setSupplier(supplier);
	}

	public static final ProductEntity create(UUID id, String name, BigDecimal price, ProductTypeEntity productType,
			SupplierEntity supplier) {
		return new ProductEntity(id, name, price, productType, supplier);
	}

	public static final ProductEntity create(UUID id) {
		return new ProductEntity(id, TextHelper.EMPTY, BigDecimal.ZERO, ProductTypeEntity.create(),
				SupplierEntity.create());
	}

	public static final ProductEntity create() {
		return new ProductEntity(UUIDHelper.getDefault(), TextHelper.EMPTY, BigDecimal.ZERO, ProductTypeEntity.create(),
				SupplierEntity.create());
	}

	public UUID getId() {
		return id;
	}

	public ProductEntity setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductEntity setName(String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public ProductEntity setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public ProductTypeEntity getProductType() {
		return productType;
	}

	public ProductEntity setProductType(ProductTypeEntity productType) {
		this.productType = ObjectHelper.getDefault(productType, ProductTypeEntity.create());
		return this;
	}

	public SupplierEntity getSupplier() {
		return supplier;
	}

	public ProductEntity setSupplier(SupplierEntity supplier) {
		this.supplier = ObjectHelper.getDefault(supplier, SupplierEntity.create());
		return this;
	}

}
