package co.inventory.system.ld.application.secondaryports.entity.inventorymovements;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductEntity;
import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "inventoryMovement")
public class InventoryMovementEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "movementType")
    private MovementTypeEntity movementType;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    public InventoryMovementEntity() {
        setId(UUIDHelper.getDefault());
        setProduct(ProductEntity.create());
        setMovementType(MovementTypeEntity.create());
        setQuantity(0);
        setUser(UserEntity.create());
    }

    public InventoryMovementEntity(UUID id, ProductEntity product, MovementTypeEntity movementType, UserEntity userEntity, int quantity) {
        setId(id);
        setProduct(product);
        setMovementType(movementType);
        setUser(userEntity);
        setQuantity(quantity);
    }

    public static final InventoryMovementEntity create(UUID id, ProductEntity product, MovementTypeEntity movementType, UserEntity userEntity, int quantity) {
        return new InventoryMovementEntity(id, product, movementType, userEntity, quantity);
    }

    public static final InventoryMovementEntity create(UUID id) {
        return new InventoryMovementEntity(id, ProductEntity.create(), MovementTypeEntity.create(), UserEntity.create(), 0);
    }

    public static final InventoryMovementEntity create() {
        return new InventoryMovementEntity(UUIDHelper.getDefault(), ProductEntity.create(), MovementTypeEntity.create(), UserEntity.create(), 0);
    }

    public UUID getId() {
        return id;
    }

    public InventoryMovementEntity setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public MovementTypeEntity getMovementType() {
        return movementType;
    }

    public InventoryMovementEntity setMovementType(MovementTypeEntity movementType) {
        this.movementType = ObjectHelper.getDefault(movementType, MovementTypeEntity.create());
        return this;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public InventoryMovementEntity setProduct(ProductEntity product) {
        this.product = ObjectHelper.getDefault(product, ProductEntity.create());
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public InventoryMovementEntity setUser(UserEntity userEntity) {
        this.user = ObjectHelper.getDefault(userEntity, UserEntity.create());
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public InventoryMovementEntity setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
