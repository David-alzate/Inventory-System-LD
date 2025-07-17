package co.inventory.system.ld.application.primaryports.dto.sales;

import co.inventory.system.ld.application.primaryports.dto.users.UserDTO;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SaleDTO {

    private UUID id;
    private UserDTO user;
    private LocalDateTime orderDate;
    private BigDecimal total;
    private List<SaleProductDTO> saleProducts;
    private SaleStatusDTO saleStatus;

    public SaleDTO() {
        setId(UUIDHelper.getDefault());
        setUser(UserDTO.create());
        setOrderDate(LocalDateTime.now());
        setTotal(BigDecimal.ZERO);
        setSaleProducts(new ArrayList<>());
        setSaleStatus(SaleStatusDTO.create());
    }

    public SaleDTO(UUID id, UserDTO user, LocalDateTime fechaPedido, BigDecimal total, List<SaleProductDTO> saleProducts, SaleStatusDTO saleStatus) {
        setId(id);
        setUser(user);
        setOrderDate(fechaPedido);
        setTotal(total);
        setSaleProducts(saleProducts);
        setSaleStatus(saleStatus);
    }

    public static SaleDTO create(UUID id, UserDTO user, LocalDateTime fechaPedido, BigDecimal total, List<SaleProductDTO> saleProducts, SaleStatusDTO saleStatus) {
        return new SaleDTO(id, user, fechaPedido, total, saleProducts, saleStatus);
    }

    public static SaleDTO create() {
        return new SaleDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = ObjectHelper.getDefault(user, UserDTO.create());
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

    public List<SaleProductDTO> getSaleProducts() {
        return saleProducts;
    }

    public void setSaleProducts(List<SaleProductDTO> saleProducts) {
        this.saleProducts = saleProducts;
    }

    public SaleStatusDTO getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatusDTO saleStatus) {
        this.saleStatus = ObjectHelper.getDefault(saleStatus, SaleStatusDTO.create());
    }
}
