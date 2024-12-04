package co.inventory.system.ld.application.primaryports.dto.commons;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import java.util.UUID;

public class GetIdTypeDTO {
    private UUID id;
    private String name;

    public GetIdTypeDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public GetIdTypeDTO(final UUID id, final String name) {
        setId(id);
        setName(name);
    }

    public static final GetIdTypeDTO create(final UUID id, final String name) {
       return new GetIdTypeDTO(id, name);
    }

    public static final GetIdTypeDTO create() {
        return new GetIdTypeDTO();
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
