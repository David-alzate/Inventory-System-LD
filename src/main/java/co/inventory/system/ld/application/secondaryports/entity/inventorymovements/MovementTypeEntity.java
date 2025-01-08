package co.inventory.system.ld.application.secondaryports.entity.inventorymovements;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "movementType")
public class MovementTypeEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    public MovementTypeEntity(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public MovementTypeEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public static final MovementTypeEntity create(UUID id, String name) {
        return new MovementTypeEntity(id, name);
    }

    public static final MovementTypeEntity create(UUID id) {
        return new MovementTypeEntity(id, TextHelper.EMPTY);
    }

    public static final MovementTypeEntity create() {
        return new MovementTypeEntity(UUIDHelper.getDefault(), TextHelper.EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public MovementTypeEntity setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public String getName() {
        return name;
    }

    public MovementTypeEntity setName(String name) {
        this.name = TextHelper.applyTrim(name);
        return this;
    }
}
