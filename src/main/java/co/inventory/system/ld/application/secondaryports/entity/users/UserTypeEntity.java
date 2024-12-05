package co.inventory.system.ld.application.secondaryports.entity.users;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "userType")
public class UserTypeEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    public UserTypeEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public UserTypeEntity(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public static UserTypeEntity create(UUID id, String name) {
        return new UserTypeEntity(id, name);
    }

    public static UserTypeEntity create(UUID id) {
        return new UserTypeEntity(id, TextHelper.EMPTY);
    }

    public static UserTypeEntity create() {
        return new UserTypeEntity(UUIDHelper.getDefault(), TextHelper.EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public UserTypeEntity setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public String getName() {
        return name;
    }

    public UserTypeEntity setName(String name) {
        this.name = TextHelper.applyTrim(name);
        return this;
    }
}

