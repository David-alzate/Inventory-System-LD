package co.inventory.system.ld.application.secondaryports.entity.suppliers;

import co.inventory.system.ld.application.secondaryports.entity.commons.StatusEntity;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Suppliers")
public class SupplierEntity {
    @Id //primary key
    @Column(name="id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "status")
    private StatusEntity status;

    public SupplierEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
        setStatus(StatusEntity.create());
    }

    public SupplierEntity(UUID id, String name, StatusEntity status) {
        setId(id);
        setName(name);
        setStatus(status);
    }

    public static SupplierEntity create() {
        return new SupplierEntity();
    }

    public static SupplierEntity create(UUID id) {
       return new SupplierEntity(id, TextHelper.EMPTY, StatusEntity.create());
    }

    public static SupplierEntity create(UUID id, String name, StatusEntity status) {
        return new SupplierEntity(id, name, status);
    }

    public UUID getId() {
        return id;
    }

    public SupplierEntity setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public String getName() {
        return name;
    }

    public SupplierEntity setName(String name) {
        this.name = TextHelper.applyTrim(name);
        return this;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public SupplierEntity setStatus(StatusEntity status) {
        this.status = ObjectHelper.getDefault(status, StatusEntity.create());
        return this;
    }
}
