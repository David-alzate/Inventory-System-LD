package co.inventory.system.ld.domain.products;

import java.math.BigDecimal;
import java.util.UUID;

import co.inventory.system.ld.domain.Domain;
import co.inventory.system.ld.domain.suppliers.SupplierDomain;

public class ProductDomain extends Domain {

	private String name;
	private BigDecimal price;
	private ProductTypeDomain productType;
	private SupplierDomain supplier;

	public ProductDomain(UUID id, String name, BigDecimal price, ProductTypeDomain productType,
			SupplierDomain supplier) {
		super(id);
		setName(name);
		setPrice(price);
		setProductType(productType);
		setSupplier(supplier);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProductTypeDomain getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeDomain productType) {
		this.productType = productType;
	}

	public SupplierDomain getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDomain supplier) {
		this.supplier = supplier;
	}

}
