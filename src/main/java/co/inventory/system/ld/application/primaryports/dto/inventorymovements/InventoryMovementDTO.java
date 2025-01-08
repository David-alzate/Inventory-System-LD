package co.inventory.system.ld.application.primaryports.dto.inventorymovements;

import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.application.primaryports.dto.users.UserDTO;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class InventoryMovementDTO {

    private UUID id;
    private ProductDTO product;
    private MovementTypeDTO movementType;
    private int quantity;
    private UserDTO user;

    public InventoryMovementDTO() {
        setId(UUIDHelper.getDefault());
        setProduct(ProductDTO.create());
        setMovementType(MovementTypeDTO.create());
        setQuantity(0);
        setUser(UserDTO.create());
    }

    public InventoryMovementDTO(UUID id, ProductDTO product, MovementTypeDTO movementType, int quantity, UserDTO user) {
        setId(id);
        setProduct(product);
        setMovementType(movementType);
        setQuantity(quantity);
        setUser(user);
    }

    public static final InventoryMovementDTO create(UUID id, ProductDTO product, MovementTypeDTO movementType, int quantity, UserDTO user){
        return new InventoryMovementDTO(id, product, movementType, quantity, user);
    }

    public static final InventoryMovementDTO create(){
        return new InventoryMovementDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
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

    public MovementTypeDTO getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementTypeDTO movementType) {
        this.movementType = ObjectHelper.getDefault(movementType, MovementTypeDTO.create());
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = ObjectHelper.getDefault(user, UserDTO.create());
    }
}
