package co.inventory.system.ld.application.primaryports.dto.commons;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import java.util.UUID;

public class IdTypeDTO {
    private UUID id;
    private String name;

    public IdTypeDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public IdTypeDTO(final UUID id, final String name) {
        setId(id);
        setName(name);
    }

    public static final IdTypeDTO create(final UUID id, final String name) {
       return new IdTypeDTO(id, name);
    }

    public static final IdTypeDTO create() {
        return new IdTypeDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.applyTrim(name);
    }
}
