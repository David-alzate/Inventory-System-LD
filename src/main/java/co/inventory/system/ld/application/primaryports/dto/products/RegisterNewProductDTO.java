package co.inventory.system.ld.application.primaryports.dto.products;

import java.math.BigDecimal;

import co.inventory.system.ld.application.primaryports.dto.suppliers.SupplierDTO;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;

public class RegisterNewProductDTO {

	private String name;
	private BigDecimal price;
	private ProductTypeDTO productType;
	private SupplierDTO supplier;

	public RegisterNewProductDTO() {
		setName(TextHelper.EMPTY);
		setPrice(BigDecimal.ZERO);
		setProductType(ProductTypeDTO.create());
		setSupplier(SupplierDTO.create());
	}

	public RegisterNewProductDTO(String name, BigDecimal price, ProductTypeDTO productType, SupplierDTO supplier) {
		setName(name);
		setPrice(price);
		setProductType(productType);
		setSupplier(supplier);
	}

	public static final RegisterNewProductDTO create(String name, BigDecimal price, ProductTypeDTO productType,
			SupplierDTO supplier) {
		return new RegisterNewProductDTO(name, price, productType, supplier);
	}

	public static final RegisterNewProductDTO create() {
		return new RegisterNewProductDTO();
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
