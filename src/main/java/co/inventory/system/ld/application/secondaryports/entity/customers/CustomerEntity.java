package co.inventory.system.ld.application.secondaryports.entity.customers;

import co.inventory.system.ld.application.secondaryports.entity.commons.IdTypeEntity;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "idType")
    private IdTypeEntity idType;

    @Column(name = "idNumber")
    private Long idNumber;

    @Column(name = "email")
    private String email;

    public CustomerEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
        setIdType(IdTypeEntity.create());
        setLastName(TextHelper.EMPTY);
        setIdNumber(0l);
        setEmail(TextHelper.EMPTY);
    }
    public CustomerEntity(UUID id, String name, IdTypeEntity idType, String lastName, Long idNumber, String email) {
        setId(id);
        setName(name);
        setIdType(idType);
        setLastName(lastName);
        setIdNumber(idNumber);
        setEmail(email);
    }

    public static CustomerEntity create(UUID id, String name, IdTypeEntity idType, String lastName, Long idNumber, String email) {
        return new CustomerEntity(id, name, idType, lastName, idNumber, email);
    }

    public static CustomerEntity create(UUID id) {
        return new CustomerEntity(id, TextHelper.EMPTY,IdTypeEntity.create(), TextHelper.EMPTY, 0l, TextHelper.EMPTY);
    }

    public static CustomerEntity create() {
        return new CustomerEntity();
    }

    public UUID getId() {
        return id;
    }

    public CustomerEntity setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerEntity setName(String name) {
        this.name = TextHelper.applyTrim(name);
        return this;
    }

    public IdTypeEntity getIdType() {
        return idType;
    }

    public CustomerEntity setIdType(IdTypeEntity idType) {
        this.idType = ObjectHelper.getDefault(idType, IdTypeEntity.create());
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerEntity setLastName(String lastName) {
        this.lastName = TextHelper.applyTrim(lastName);
        return this;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public CustomerEntity setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerEntity setEmail(String email) {
        this.email = TextHelper.applyTrim(email);
        return this;
    }
}
