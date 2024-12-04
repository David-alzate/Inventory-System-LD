package co.inventory.system.ld.application.primaryports.dto.suppliers;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.commons.StatusDomain;

public class RegisterNewSupplierDTO {
    private  String name;
    private StatusDomain status;

    public RegisterNewSupplierDTO(String name, StatusDomain status) {
        setName(name);
        setStatus(status);
    }

    public RegisterNewSupplierDTO create(String name, StatusDomain status) {
        return new RegisterNewSupplierDTO(name, status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =  TextHelper.applyTrim(name);
    }

    public StatusDomain getStatus() {
        return status;
    }

    public void setStatus(StatusDomain status) {
        this.status = status;
    }
}
