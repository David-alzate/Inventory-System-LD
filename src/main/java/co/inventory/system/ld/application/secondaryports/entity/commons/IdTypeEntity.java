package co.inventory.system.ld.application.secondaryports.entity.commons;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "idType")
public class IdTypeEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    public IdTypeEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public IdTypeEntity(final UUID id, final String name) {
        setId(id);
        setName(name);
    }

    public  static final IdTypeEntity create(){
        return new IdTypeEntity();
    }

    public static final IdTypeEntity create(final UUID id){
        return new IdTypeEntity(id, TextHelper.EMPTY);
    }

    public static final IdTypeEntity create(final UUID id, final String name){
        return new IdTypeEntity(id, name);
    }

    public UUID getId() {
        return id;
    }

    public IdTypeEntity setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public String getName() {
        return name;
    }

    public IdTypeEntity setName(final String name) {
        this.name = TextHelper.applyTrim(name);
        return this;
    }
}
