package co.inventory.system.ld.domain.commons;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.Domain;

import java.util.UUID;

public class IdTypeDomain extends Domain {
    private String name;

    public IdTypeDomain(UUID id, String name) {
        super(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.applyTrim(name);
    }
}
