package co.inventory.system.ld.application.primaryports.dto.products;

import java.math.BigDecimal;
import java.util.UUID;

import co.inventory.system.ld.application.primaryports.dto.suppliers.SupplierDTO;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

public class ProductDTO {

	private UUID id;
	private String name;
	private BigDecimal price;
	private ProductTypeDTO productType;
	private SupplierDTO supplier;

	public ProductDTO() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setPrice(BigDecimal.ZERO);
		setProductType(ProductTypeDTO.create());
		setSupplier(SupplierDTO.create());
	}

	public ProductDTO(UUID id, String name, BigDecimal price, ProductTypeDTO productType, SupplierDTO supplier) {
		setId(id);
		setName(name);
		setPrice(price);
		setProductType(productType);
		setSupplier(supplier);
	}

	public static final ProductDTO create(UUID id, String name, BigDecimal price, ProductTypeDTO productType,
			SupplierDTO supplier) {
		return new ProductDTO(id, name, price, productType, supplier);
	}

	public static final ProductDTO create() {
		return new ProductDTO();
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

	public ProductTypeDTO getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeDTO productType) {
		this.productType = ObjectHelper.getDefault(productType, ProductTypeDTO.create());
	}

	public SupplierDTO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDTO supplier) {
		this.supplier = ObjectHelper.getDefault(supplier, SupplierDTO.create());
	}

}
