package co.inventory.system.ld.domain.inventorymovements;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.Domain;

import java.util.UUID;

public class MovementTypeDomain extends Domain {

    private String name;

    public MovementTypeDomain(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.applyTrim(name);
    }
}
