package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.commons.impl;

import java.util.ArrayList;
import java.util.List;

import co.inventory.system.ld.application.secondaryports.entity.commons.StatusEntity;
import co.inventory.system.ld.crosscutting.exceptions.RepositoryInventorySystemException;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.commons.StatusRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

public class StatusRepositoryCustomImpl implements StatusRepositoryCustom {

	private final EntityManager entityManager;

	public StatusRepositoryCustomImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<StatusEntity> findByFilter(StatusEntity filter) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(StatusEntity.class);
			var result = query.from(StatusEntity.class);

			var predicates = new ArrayList<Predicate>();

			if (!ObjectHelper.isNull(filter)) {
				if (!UUIDHelper.isDefault(filter.getId())) {
					predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
				}
				if (!TextHelper.isEmpty(filter.getName())) {
					predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(result.get("name")),
							filter.getName().toUpperCase()));
				}
			}

			query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
			return entityManager.createQuery(query).getResultList();

		} catch (final Exception exception) {
			throw RepositoryInventorySystemException.create(null, null, exception);
		}
	}
}
