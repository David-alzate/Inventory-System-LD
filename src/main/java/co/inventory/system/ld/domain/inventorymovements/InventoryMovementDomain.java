package co.inventory.system.ld.domain.inventorymovements;

import co.inventory.system.ld.domain.Domain;
import co.inventory.system.ld.domain.products.ProductDomain;
import co.inventory.system.ld.domain.users.UserDomain;

import java.util.UUID;

public class InventoryMovementDomain extends Domain {

    private ProductDomain product;
    private MovementTypeDomain movementType;
    private int quantity;
    private UserDomain user;

    public InventoryMovementDomain(UUID id, ProductDomain product, MovementTypeDomain movementType, int quantity, UserDomain user) {
        super(id);
        setProduct(product);
        setMovementType(movementType);
        setQuantity(quantity);
        setUser(user);
    }

    public ProductDomain getProduct() {
        return product;
    }

    public void setProduct(ProductDomain product) {
        this.product = product;
    }

    public MovementTypeDomain getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementTypeDomain movementType) {
        this.movementType = movementType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UserDomain getUser() {
        return user;
    }

    public void setUser(UserDomain user) {
        this.user = user;
    }
}
