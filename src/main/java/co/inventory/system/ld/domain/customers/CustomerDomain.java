package co.inventory.system.ld.domain.customers;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.Domain;
import co.inventory.system.ld.domain.commons.IdTypeDomain;

import java.util.UUID;

public class CustomerDomain extends Domain {

    private  String name;
    private String lastName;
    private IdTypeDomain idType;
    private Long idNumber;
    private  String email;

    public CustomerDomain(UUID id, String name, String lastName, IdTypeDomain idType, Long idNumber, String email) {
        super(id);
        setName(name);
        setLastName(lastName);
        setIdType(idType);
        setIdNumber(idNumber);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.applyTrim(name);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName =  TextHelper.applyTrim(lastName);
    }

    public IdTypeDomain getIdType() {
        return idType;
    }

    public void setIdType(IdTypeDomain idType) {
        this.idType = idType;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = TextHelper.applyTrim(email);
    }
}
