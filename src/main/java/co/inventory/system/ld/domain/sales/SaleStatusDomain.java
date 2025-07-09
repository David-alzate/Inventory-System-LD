package co.inventory.system.ld.domain.sales;

import co.inventory.system.ld.domain.Domain;

import java.util.UUID;

public class SaleStatusDomain extends Domain {

    private String name;

    public SaleStatusDomain(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
