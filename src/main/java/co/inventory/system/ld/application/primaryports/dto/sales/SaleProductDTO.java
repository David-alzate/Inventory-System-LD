package co.inventory.system.ld.application.primaryports.dto.sales;

import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

import java.math.BigDecimal;
import java.util.UUID;

public class SaleProductDTO {

    private UUID id;
    private SaleDTO sale;
    private ProductDTO product;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;

    public SaleProductDTO() {
        setId(UUIDHelper.getDefault());
        setSale(SaleDTO.create());
        setProduct(ProductDTO.create());
        setQuantity(0);
        setUnitPrice(BigDecimal.ZERO);
        setSubtotal(BigDecimal.ZERO);
    }

    public SaleProductDTO(UUID id, SaleDTO sale, ProductDTO product, int quantity, BigDecimal unitPrice, BigDecimal subtotal) {
        setId(id);
        setSale(sale);
        setProduct(product);
        setQuantity(quantity);
        setUnitPrice(unitPrice);
        setSubtotal(subtotal);
    }

    public static SaleProductDTO create(UUID id, SaleDTO sale, ProductDTO product, int quantity, BigDecimal unitPrice, BigDecimal subtotal) {
        return new SaleProductDTO(id, sale, product, quantity, unitPrice, subtotal);
    }

    public static SaleProductDTO create() {
        return new SaleProductDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public SaleDTO getSale() {
        return sale;
    }

    public void setSale(SaleDTO sale) {
        this.sale = ObjectHelper.getDefault(sale, SaleDTO.create());
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = ObjectHelper.getDefault(product, ProductDTO.create());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
