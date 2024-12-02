package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.commons.impl;

import co.inventory.system.ld.application.secondaryports.entity.commons.IdTypeEntity;
import co.inventory.system.ld.crosscutting.exceptions.RepositoryInventorySystemException;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.commons.IdTypeRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class IdTypeRepositoryCustomImpl implements IdTypeRepositoryCustom {

    private final EntityManager entityManager;

    public IdTypeRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<IdTypeEntity> findByFilter(final IdTypeEntity filter) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(IdTypeEntity.class);
            var result = query.from(IdTypeEntity.class);

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

        }catch (final Exception exception){
            throw RepositoryInventorySystemException.create(null, null, exception);
        }
    }
}
