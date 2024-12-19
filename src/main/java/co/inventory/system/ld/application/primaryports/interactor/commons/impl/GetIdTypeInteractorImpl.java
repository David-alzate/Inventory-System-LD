package co.inventory.system.ld.application.primaryports.interactor.commons.impl;

import co.inventory.system.ld.application.primaryports.dto.commons.IdTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.commons.GetIdTypeInteractor;
import co.inventory.system.ld.application.primaryports.mapper.commons.IdTypeDTOMapper;
import co.inventory.system.ld.application.usecase.commons.GetIdType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GetIdTypeInteractorImpl implements GetIdTypeInteractor {

	private final GetIdType getIdType;

	public GetIdTypeInteractorImpl(GetIdType getIdType) {
		this.getIdType = getIdType;
	}

	@Override
	public List<IdTypeDTO> execute(IdTypeDTO data) {
		var idTypeDomain = IdTypeDTOMapper.INSTANCE.toDomain(data);
		var results = getIdType.execute(idTypeDomain);
		return IdTypeDTOMapper.INSTANCE.toDTOCollection(results);
	}
}
