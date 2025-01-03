package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.inventorymovements.impl;

import co.inventory.system.ld.application.secondaryports.entity.inventorymovements.InventoryMovementEntity;
import co.inventory.system.ld.crosscutting.exceptions.RepositoryInventorySystemException;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.inventorymovements.InventoryMovementsRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;


public class InventoryMovementsRepositoryCustomImpl implements InventoryMovementsRepositoryCustom {

    private final EntityManager entityManager;

    public InventoryMovementsRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<InventoryMovementEntity> findByFilter(InventoryMovementEntity filter) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(InventoryMovementEntity.class);
            var result = query.from(InventoryMovementEntity.class);

            var predicates = new ArrayList<Predicate>();

            if (!ObjectHelper.isNull(filter)) {
                if (!UUIDHelper.isDefault(filter.getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
                }
                if (!UUIDHelper.isDefault(filter.getProduct().getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("product").get("id"),filter.getProduct().getId()));
                }

                if (!UUIDHelper.isDefault(filter.getMovementType().getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("movementType").get("id"),filter.getMovementType().getId()));
                }
                if (!UUIDHelper.isDefault(filter.getUser().getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("user").get("id"), filter.getUser().getId()));
                }

                if (!UUIDHelper.isDefault(filter.getUser().getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("user").get("id"), filter.getUser().getId()));
                }
            }

            query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return entityManager.createQuery(query).getResultList();

        } catch (final Exception exception) {
            throw RepositoryInventorySystemException.create(null, null, exception);
        }
    }

}
