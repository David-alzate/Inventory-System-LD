package co.inventory.system.ld.domain.sales;

import co.inventory.system.ld.domain.Domain;
import co.inventory.system.ld.domain.products.ProductDomain;

import java.math.BigDecimal;
import java.util.UUID;

public class SaleProductDomain extends Domain {

    private SaleDomain sale;
    private ProductDomain product;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;

    public SaleProductDomain(UUID id, SaleDomain sale, ProductDomain product, int quantity, BigDecimal unitPrice, BigDecimal subtotal) {
        super(id);
        setSale(sale);
        setProduct(product);
        setQuantity(quantity);
        setUnitPrice(unitPrice);
        setSubtotal(subtotal);
    }

    public SaleDomain getSale() {
        return sale;
    }

    public void setSale(SaleDomain sale) {
        this.sale = sale;
    }

    public ProductDomain getProduct() {
        return product;
    }

    public void setProduct(ProductDomain product) {
        this.product = product;
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
