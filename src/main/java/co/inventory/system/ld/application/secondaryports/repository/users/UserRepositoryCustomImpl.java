package co.inventory.system.ld.application.secondaryports.repository.users;

import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.crosscutting.exceptions.RepositoryInventorySystemException;
import co.inventory.system.ld.crosscutting.helpers.NumericHelper;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final EntityManager entityManager;

    public UserRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserEntity> findByFilter(UserEntity filter) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(UserEntity.class);
            var result = query.from(UserEntity.class);

            var predicates = new ArrayList<Predicate>();

            if (!ObjectHelper.isNull(filter)) {
                if (!UUIDHelper.isDefault(filter.getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
                }
                if (!TextHelper.isEmpty(filter.getName())) {
                    predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(result.get("name")), filter.getName().toUpperCase()));
                }
                if (!TextHelper.isEmpty(filter.getName())) {
                    predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(result.get("lastName")), filter.getLastName().toUpperCase()));
                }
                if (!UUIDHelper.isDefault(filter.getStatus().getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("idType").get("id"), filter.getIdType().getId()));
                }
                if (!NumericHelper.isEqual(filter.getIdNumber(), 0L)) {
                    predicates.add(criteriaBuilder.equal(result.get("idNumber"), filter.getIdNumber()));
                }
                if (!TextHelper.isEmpty(filter.getName())) {
                    predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(result.get("email")), filter.getEmail().toUpperCase()));
                }
                if (!UUIDHelper.isDefault(filter.getStatus().getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("userType").get("id"), filter.getUserType().getId()));
                }
                if (!UUIDHelper.isDefault(filter.getStatus().getId())) {
                    predicates.add(criteriaBuilder.equal(result.get("status").get("id"), filter.getStatus().getId()));
                }
                if (!TextHelper.isEmpty(filter.getName())) {
                    predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(result.get("password")), filter.getPassword().toUpperCase()));
                }
            }

            query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return entityManager.createQuery(query).getResultList();

        } catch (final Exception exception) {
            throw RepositoryInventorySystemException.create(null, null, exception);
        }
    }
}
