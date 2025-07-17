package co.inventory.system.ld.domain.sales;

import co.inventory.system.ld.domain.Domain;
import co.inventory.system.ld.domain.users.UserDomain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SaleDomain extends Domain {

    private UserDomain user;
    private LocalDateTime orderDate;
    private BigDecimal total;
    private List<SaleProductDomain> saleProducts;
    private SaleStatusDomain saleStatus;

    public SaleDomain(UUID id, UserDomain user, LocalDateTime orderDate, BigDecimal total, List<SaleProductDomain> saleProducts, SaleStatusDomain saleStatus) {
        super(id);
        setUser(user);
        setOrderDate(orderDate);
        setTotal(total);
        setSaleProducts(saleProducts);
        setSaleStatus(saleStatus);
    }

    public UserDomain getUser() {
        return user;
    }

    public void setUser(UserDomain user) {
        this.user = user;
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

    public List<SaleProductDomain> getSaleProducts() {
        return saleProducts;
    }

    public void setSaleProducts(List<SaleProductDomain> saleProducts) {
        this.saleProducts = saleProducts;
    }

    public SaleStatusDomain getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatusDomain saleStatus) {
        this.saleStatus = saleStatus;
    }
}
