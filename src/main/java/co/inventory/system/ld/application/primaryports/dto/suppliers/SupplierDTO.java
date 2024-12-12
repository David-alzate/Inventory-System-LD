package co.inventory.system.ld.application.primaryports.dto.suppliers;

import co.inventory.system.ld.application.primaryports.dto.commons.StatusDTO;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class SupplierDTO {

    private UUID id;
    private  String name;
    private StatusDTO status;

    public SupplierDTO() {
        setId(UUIDHelper.getDefault());
        setStatus(StatusDTO.create());
        setName(TextHelper.EMPTY);
    }

    public SupplierDTO(UUID id, String name, StatusDTO status) {
        setId(id);
        setName(name);
        setStatus(status);
    }

    public static final SupplierDTO create() {
        return new SupplierDTO();
    }

    public static SupplierDTO create(UUID id, String name, StatusDTO status) {
        return new SupplierDTO(id, name, status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =  TextHelper.applyTrim(name);
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }
}
