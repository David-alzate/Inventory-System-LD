package co.inventory.system.ld.application.secondaryports.entity.sales;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "sale_status")
public class SaleStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    public SaleStatusEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public SaleStatusEntity(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public static SaleStatusEntity create(UUID id, String name) {
        return new SaleStatusEntity(id, name);
    }

    public static SaleStatusEntity create(UUID id) {
        return new SaleStatusEntity(id, TextHelper.EMPTY);
    }

    public static SaleStatusEntity create() {
        return new SaleStatusEntity(UUIDHelper.getDefault(), TextHelper.EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public SaleStatusEntity setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public String getName() {
        return name;
    }

    public SaleStatusEntity setName(String name) {
        this.name = TextHelper.applyTrim(name);
        return this;
    }
}
