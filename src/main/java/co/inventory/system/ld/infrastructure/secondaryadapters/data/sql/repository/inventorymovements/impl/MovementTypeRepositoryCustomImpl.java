package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.inventorymovements.impl;

import co.inventory.system.ld.application.secondaryports.entity.inventorymovements.MovementTypeEntity;
import co.inventory.system.ld.crosscutting.exceptions.RepositoryInventorySystemException;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.inventorymovements.MovementTypeRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class MovementTypeRepositoryCustomImpl implements MovementTypeRepositoryCustom {

    private EntityManager entityManager;

    public MovementTypeRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<MovementTypeEntity> findByFilter(MovementTypeEntity filter) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(MovementTypeEntity.class);
            var result = query.from(MovementTypeEntity.class);

            var predicates = new ArrayList<Predicate>();

            if (!ObjectHelper.isNull(filter)) {
                if (!UUIDHelper.isDefault(filter.getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
                }
                if (!TextHelper.isEmpty(filter.getName())) {
                    predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(result.get("name")), filter.getName().toUpperCase()));
                }
            }

            query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return entityManager.createQuery(query).getResultList();

        } catch (final Exception exception) {
            throw RepositoryInventorySystemException.create(null, null, exception);
        }
    }
}
