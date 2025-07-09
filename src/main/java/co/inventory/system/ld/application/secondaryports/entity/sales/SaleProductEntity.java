package co.inventory.system.ld.application.secondaryports.entity.sales;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductEntity;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "sale_product")
public class SaleProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sale")
    private SaleEntity sale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private ProductEntity product;
    private int quantity;

    @Column(name = "id_unit_price")
    private BigDecimal unitPrice;
    private BigDecimal subtotal;

    public SaleProductEntity() {
        setId(UUIDHelper.getDefault());
        setSale(SaleEntity.create());
        setProduct(ProductEntity.create());
        setQuantity(0);
        setUnitPrice(BigDecimal.ZERO);
        setSubtotal(BigDecimal.ZERO);
    }

    public SaleProductEntity(UUID id, SaleEntity sale, ProductEntity product, int quantity, BigDecimal unitPrice, BigDecimal subtotal) {
        setId(id);
        setSale(sale);
        setProduct(product);
        setQuantity(quantity);
        setUnitPrice(unitPrice);
        setSubtotal(subtotal);
    }

    public static SaleProductEntity create(UUID id, SaleEntity sale, ProductEntity product, int quantity, BigDecimal unitPrice, BigDecimal subtotal) {
        return new SaleProductEntity(id, sale, product, quantity, unitPrice, subtotal);
    }

    public static SaleProductEntity create(UUID id) {
        return new SaleProductEntity(id, SaleEntity.create(), ProductEntity.create(), 0, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public SaleEntity getSale() {
        return sale;
    }

    public void setSale(SaleEntity sale) {
        this.sale = ObjectHelper.getDefault(sale, SaleEntity.create());
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = ObjectHelper.getDefault(product, ProductEntity.create());
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
