package co.inventory.system.ld.application.primaryports.dto.suppliers;

import co.inventory.system.ld.application.primaryports.dto.commons.StatusDTO;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;

public class RegisterNewSupplierDTO {
    private  String name;
    private StatusDTO status;

    public RegisterNewSupplierDTO(String name, StatusDTO status) {
        setName(name);
        setStatus(status);
    }

    public RegisterNewSupplierDTO create(String name, StatusDTO status) {
        return new RegisterNewSupplierDTO(name, status);
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
}
