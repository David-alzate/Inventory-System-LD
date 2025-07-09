package co.inventory.system.ld.application.secondaryports.entity.sales;

import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "sale")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    private LocalDateTime orderDate;
    private BigDecimal total;

    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleProductEntity> saleProducts;

    @ManyToOne
    @JoinColumn(name = "id_sale_status")
    private SaleStatusEntity saleStatus;

    public SaleEntity() {
        setId(UUIDHelper.getDefault());
        setUser(UserEntity.create());
        setOrderDate(LocalDateTime.now());
        setTotal(BigDecimal.ZERO);
        setSaleProducts(new ArrayList<>());
        setSaleStatus(SaleStatusEntity.create());
    }

    public SaleEntity(UUID id, UserEntity user, LocalDateTime fechaPedido, BigDecimal total, List<SaleProductEntity> saleProducts, SaleStatusEntity saleStatus) {
        setId(id);
        setUser(user);
        setOrderDate(fechaPedido);
        setTotal(total);
        setSaleProducts(saleProducts);
        setSaleStatus(saleStatus);
    }

    public static SaleEntity create(UUID id, UserEntity user, LocalDateTime fechaPedido, BigDecimal total, List<SaleProductEntity> saleProducts, SaleStatusEntity saleStatus) {
        return new SaleEntity(id, user, fechaPedido, total, saleProducts, saleStatus);
    }

    public static SaleEntity create(UUID id) {
        return new SaleEntity(id, UserEntity.create(), LocalDateTime.now(), BigDecimal.ZERO, new ArrayList<>(), SaleStatusEntity.create());
    }

    public static SaleEntity create() {
        return new SaleEntity(UUIDHelper.getDefault(), UserEntity.create(), LocalDateTime.now(), BigDecimal.ZERO, new ArrayList<>(), SaleStatusEntity.create());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = ObjectHelper.getDefault(user, UserEntity.create());
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<SaleProductEntity> getSaleProducts() {
        return saleProducts;
    }

    public void setSaleProducts(List<SaleProductEntity> saleProducts) {
        this.saleProducts = saleProducts;
    }

    public SaleStatusEntity getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatusEntity saleStatus) {
        this.saleStatus = ObjectHelper.getDefault(saleStatus, SaleStatusEntity.create());
    }
}
