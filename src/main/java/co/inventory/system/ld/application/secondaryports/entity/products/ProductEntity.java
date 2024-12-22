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

	@Column(name = "stock")
	private int stock;

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
		setStock(0);
		setProductType(ProductTypeEntity.create());
		setSupplier(SupplierEntity.create());
	}

	public ProductEntity(UUID id, String name, BigDecimal price, int stock, ProductTypeEntity productType,
			SupplierEntity supplier) {
		setId(id);
		setName(name);
		setPrice(price);
		setStock(stock);
		setProductType(productType);
		setSupplier(supplier);
	}

	public static final ProductEntity create(UUID id, String name, BigDecimal price, int stock,
			ProductTypeEntity productType, SupplierEntity supplier) {
		return new ProductEntity(id, name, price, stock, productType, supplier);
	}

	public static final ProductEntity create(UUID id) {
		return new ProductEntity(id, TextHelper.EMPTY, BigDecimal.ZERO, 0, ProductTypeEntity.create(),
				SupplierEntity.create());
	}

	public static final ProductEntity create() {
		return new ProductEntity(UUIDHelper.getDefault(), TextHelper.EMPTY, BigDecimal.ZERO, 0,
				ProductTypeEntity.create(), SupplierEntity.create());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public ProductTypeEntity getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeEntity productType) {
		this.productType = ObjectHelper.getDefault(productType, ProductTypeEntity.create());
	}

	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = ObjectHelper.getDefault(supplier, SupplierEntity.create());
	}

}
