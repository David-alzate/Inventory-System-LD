package co.inventory.system.ld.application.primaryports.dto.inventorymovements;

import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.application.primaryports.dto.users.UserDTO;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;

public class RegisterNewInventoryMovementDTO {

    private ProductDTO product;
    private MovementTypeDTO movementType;
    private int quantity;
    private UserDTO user;

    public RegisterNewInventoryMovementDTO() {
        setProduct(ProductDTO.create());
        setMovementType(MovementTypeDTO.create());
        setQuantity(0);
        setUser(UserDTO.create());
    }

    public RegisterNewInventoryMovementDTO(ProductDTO product, int quantity, MovementTypeDTO movementType, UserDTO user) {
        setProduct(product);
        setMovementType(movementType);
        setQuantity(quantity);
        setUser(user);
    }

    public static final RegisterNewInventoryMovementDTO create(ProductDTO product, int quantity, MovementTypeDTO movementType, UserDTO user) {
       return new RegisterNewInventoryMovementDTO(product, quantity, movementType, user);
    }

    public static final RegisterNewInventoryMovementDTO create() {
        return new RegisterNewInventoryMovementDTO();
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = ObjectHelper.getDefault(product, ProductDTO.create());
    }

    public MovementTypeDTO getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementTypeDTO movementType) {
        this.movementType = ObjectHelper.getDefault(movementType, MovementTypeDTO.create());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = ObjectHelper.getDefault(user, UserDTO.create());
    }
}
