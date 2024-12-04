package co.inventory.system.ld.domain.suppliers;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.Domain;
import co.inventory.system.ld.domain.commons.StatusDomain;

import java.util.UUID;

public class SupplierDomain extends Domain {
    private String name;
    private StatusDomain status;

    public SupplierDomain(UUID id, String name, StatusDomain status) {
        super(id);
        setName(name);
        setStatus(status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.applyTrim(name);
    }

    public StatusDomain getStatus() {
        return status;
    }

    public void setStatus(StatusDomain status) {
        this.status = status;
    }
}
