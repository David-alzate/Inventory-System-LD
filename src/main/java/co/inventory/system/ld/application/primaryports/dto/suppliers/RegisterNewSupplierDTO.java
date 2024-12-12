package co.inventory.system.ld.application.primaryports.dto.suppliers;

import co.inventory.system.ld.application.primaryports.dto.commons.StatusDTO;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;

public class RegisterNewSupplierDTO {
    private String name;
    private StatusDTO status;

    public RegisterNewSupplierDTO(final String name, final StatusDTO status) {
        setName(name);
        setStatus(status);
    }

    public static final RegisterNewSupplierDTO create(final String name, final StatusDTO status) {
        return new RegisterNewSupplierDTO(name, status);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name =  TextHelper.applyTrim(name);
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(final StatusDTO status) {
        this.status = status;
    }
}
