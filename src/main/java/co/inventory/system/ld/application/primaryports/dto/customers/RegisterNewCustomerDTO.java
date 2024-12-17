package co.inventory.system.ld.application.primaryports.dto.customers;

import co.inventory.system.ld.application.primaryports.dto.commons.IdTypeDTO;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;

public class RegisterNewCustomerDTO {
    private  String name;
    private String lastName;
    private IdTypeDTO idType;
    private Long idNumber;
    private  String email;

    public RegisterNewCustomerDTO() {
        setName(TextHelper.EMPTY);
        setLastName(TextHelper.EMPTY);
        setIdType(IdTypeDTO.create());
        setIdNumber(0L);
        setEmail(TextHelper.EMPTY);
    }

    public RegisterNewCustomerDTO( String name, String lastName, IdTypeDTO idType, Long idNumber, String email) {
        setName(name);
        setLastName(lastName);
        setIdType(idType);
        setIdNumber(idNumber);
        setEmail(email);
    }

    public static RegisterNewCustomerDTO create(String name, String lastName, IdTypeDTO idType, Long idNumber, String email) {
        return new RegisterNewCustomerDTO(name, lastName, idType, idNumber, email);
    }

    public static RegisterNewCustomerDTO create() {
        return new RegisterNewCustomerDTO();
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
        this.lastName = TextHelper.applyTrim(lastName);
    }

    public IdTypeDTO getIdType() {
        return idType;
    }

    public void setIdType(IdTypeDTO idType) {
        this.idType = ObjectHelper.getDefault(idType, IdTypeDTO.create());
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
