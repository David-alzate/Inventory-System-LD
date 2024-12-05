package co.inventory.system.ld.application.secondaryports.entity.users;

import co.inventory.system.ld.application.secondaryports.entity.commons.IdTypeEntity;
import co.inventory.system.ld.application.secondaryports.entity.commons.StatusEntity;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity {

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

    @ManyToOne
    @JoinColumn(name = "userType")
    private UserTypeEntity userType;

    @ManyToOne
    @JoinColumn(name = "status")
    private StatusEntity status;

    @Column(name = "password")
    private String password;

    public UserEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
        setLastName(TextHelper.EMPTY);
        setIdType(IdTypeEntity.create());
        setIdNumber(0L);
        setEmail(TextHelper.EMPTY);
        setUserType(UserTypeEntity.create());
        setStatus(StatusEntity.create());
        setPassword(TextHelper.EMPTY);
    }

    public UserEntity(UUID id, String name, String lastName, IdTypeEntity idType, Long idNumber, String email, UserTypeEntity userType, StatusEntity status, String password) {
        setId(id);
        setName(name);
        setLastName(lastName);
        setIdType(idType);
        setIdNumber(idNumber);
        setEmail(email);
        setUserType(userType);
        setStatus(status);
        setPassword(password);
    }

    public static UserEntity create(UUID id, String name, String lastName, IdTypeEntity idType, Long idNumber, String email, UserTypeEntity userType, StatusEntity status, String password) {
        return new UserEntity(id, name, lastName, idType, idNumber, email, userType, status, password);
    }

    public static UserEntity create(UUID id) {
        return new UserEntity(id, TextHelper.EMPTY, TextHelper.EMPTY, IdTypeEntity.create(), 0L, TextHelper.EMPTY, UserTypeEntity.create(), StatusEntity.create(), TextHelper.EMPTY);
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = TextHelper.applyTrim(lastName);
    }

    public IdTypeEntity getIdType() {
        return idType;
    }

    public void setIdType(IdTypeEntity idType) {
        this.idType = ObjectHelper.getDefault(idType, IdTypeEntity.create());
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

    public UserTypeEntity getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEntity userType) {
        this.userType = ObjectHelper.getDefault(userType, UserTypeEntity.create());
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = TextHelper.applyTrim(password);
    }
}
