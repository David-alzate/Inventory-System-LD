package co.inventory.system.ld.application.primaryports.dto.sales;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class SaleStatusDTO {

    private UUID id;
    private String name;

    public SaleStatusDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public SaleStatusDTO(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public static SaleStatusDTO create(UUID id, String name) {
        return new SaleStatusDTO(id, name);
    }

    public static SaleStatusDTO create() {
        return new SaleStatusDTO();
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
