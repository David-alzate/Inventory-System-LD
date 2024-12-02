package co.inventory.system.ld.application.usecase.commons.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.inventory.system.ld.application.secondaryports.mapper.commons.StatusEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.commons.StatusRepository;
import co.inventory.system.ld.application.usecase.commons.GetStatus;
import co.inventory.system.ld.domain.commons.StatusDomain;

@Repository
public class GetStatusImpl implements GetStatus {

	private final StatusRepository statusRepository;

	public GetStatusImpl(StatusRepository statusRepository) {
		super();
		this.statusRepository = statusRepository;
	}

	@Override
	public List<StatusDomain> execute(StatusDomain domain) {
		var statusEntity = StatusEntityMapper.INSTANCE.toEntity(domain);
		var resultados = statusRepository.findByFilter(statusEntity);
		return StatusEntityMapper.INSTANCE.toDomainCollection(resultados);
	}

}
