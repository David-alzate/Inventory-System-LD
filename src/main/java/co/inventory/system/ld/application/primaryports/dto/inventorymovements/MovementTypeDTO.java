package co.inventory.system.ld.application.primaryports.dto.inventorymovements;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class MovementTypeDTO {

    private UUID id;
    private String name;

    public MovementTypeDTO(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public MovementTypeDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public static final MovementTypeDTO create(UUID id, String name) {
        return new MovementTypeDTO(id, name);
    }

    public static final MovementTypeDTO create() {
        return new MovementTypeDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.applyTrim(name);
    }
}
