package co.inventory.system.ld.application.primaryports.dto.customers;

import co.inventory.system.ld.application.primaryports.dto.commons.IdTypeDTO;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class CustomerDTO {

    private UUID id;
    private  String name;
    private String lastName;
    private IdTypeDTO idType;
    private Long idNumber;
    private  String email;

    public CustomerDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
        setLastName(TextHelper.EMPTY);
        setIdType(IdTypeDTO.create());
        setIdNumber(0L);
        setEmail(TextHelper.EMPTY);
    }

    public CustomerDTO(UUID id, String name, String lastName, IdTypeDTO idType, Long idNumber, String email) {
       setId(id);
       setName(name);
       setLastName(lastName);
       setIdType(idType);
       setIdNumber(idNumber);
       setEmail(email);
    }

    public static CustomerDTO create(UUID id, String name, String lastName, IdTypeDTO idType, Long idNumber, String email) {
       return new CustomerDTO(id, name, lastName, idType, idNumber, email);
    }

    public static CustomerDTO create() {
        return new CustomerDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id,UUIDHelper.getDefault());
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
