package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.products.impl;

import java.util.ArrayList;
import java.util.List;

import co.inventory.system.ld.application.secondaryports.entity.products.ProductEntity;
import co.inventory.system.ld.crosscutting.exceptions.RepositoryInventorySystemException;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.products.ProductsRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

public class ProductsRepositoryCustomImpl implements ProductsRepositoryCustom {

	private final EntityManager entityManager;

	public ProductsRepositoryCustomImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<ProductEntity> findByFilter(ProductEntity filter) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(ProductEntity.class);
			var result = query.from(ProductEntity.class);

			var predicates = new ArrayList<Predicate>();

			if (!ObjectHelper.isNull(filter)) {
				if (!UUIDHelper.isDefault(filter.getId())) {
					predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
				}
				if (!TextHelper.isEmpty(filter.getName())) {
					predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(result.get("name")), filter.getName().toUpperCase()));
				}
				if (!UUIDHelper.isDefault(filter.getProductType().getId())) {
					predicates.add(criteriaBuilder.equal(result.get("productType").get("id"),filter.getProductType().getId()));
				}
				if (!UUIDHelper.isDefault(filter.getSupplier().getId())) {
					predicates.add(criteriaBuilder.equal(result.get("supplier").get("id"), filter.getSupplier().getId()));
				}
			}

			query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
			return entityManager.createQuery(query).getResultList();

		} catch (final Exception exception) {
			throw RepositoryInventorySystemException.create(null, null, exception);
		}
	}

}
