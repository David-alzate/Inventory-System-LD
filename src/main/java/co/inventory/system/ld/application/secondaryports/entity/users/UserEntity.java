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

    public static UserEntity create() {
        return new UserEntity();
    }

    public UUID getId() {
        return id;
    }

    public UserEntity setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = TextHelper.applyTrim(name);
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = TextHelper.applyTrim(lastName);
        return this;
    }

    public IdTypeEntity getIdType() {
        return idType;
    }

    public UserEntity setIdType(IdTypeEntity idType) {
        this.idType = ObjectHelper.getDefault(idType, IdTypeEntity.create());
        return this;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public UserEntity setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = TextHelper.applyTrim(email);
        return this;
    }

    public UserTypeEntity getUserType() {
        return userType;
    }

    public UserEntity setUserType(UserTypeEntity userType) {
        this.userType = ObjectHelper.getDefault(userType, UserTypeEntity.create());
        return this;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public UserEntity setStatus(StatusEntity status) {
        this.status = status;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = TextHelper.applyTrim(password);
        return this;
    }
}
