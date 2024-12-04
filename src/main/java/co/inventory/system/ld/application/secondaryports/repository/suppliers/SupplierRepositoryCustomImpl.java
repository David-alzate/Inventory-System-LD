package co.inventory.system.ld.application.secondaryports.repository.suppliers;

import co.inventory.system.ld.application.secondaryports.entity.suppliers.SupplierEntity;
import co.inventory.system.ld.crosscutting.exceptions.RepositoryInventorySystemException;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class SupplierRepositoryCustomImpl implements SupplierRepositoryCustom{

    private final EntityManager entityManager;

    public SupplierRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<SupplierEntity> findByFilter(SupplierEntity filter) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(SupplierEntity.class);
            var result = query.from(SupplierEntity.class);

            var predicates = new ArrayList<Predicate>();

            if (!ObjectHelper.isNull(filter)) {

                if (!UUIDHelper.isDefault(filter.getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
                }
                if (!TextHelper.isEmpty(filter.getName())) {
                    predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(result.get("name")),
                            filter.getName().toUpperCase()));
                }
                if (!UUIDHelper.isDefault(filter.getStatus().getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("status").get("id"), filter.getStatus().getId()));
                }
            }

            query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return entityManager.createQuery(query).getResultList();

        } catch (final Exception exception) {
            throw RepositoryInventorySystemException.create(null, null, exception);
        }
    }
}
