package co.inventory.system.ld.application.primaryports.interactor.commons.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.primaryports.dto.commons.StatusDTO;
import co.inventory.system.ld.application.primaryports.interactor.commons.GetStatusInteractor;
import co.inventory.system.ld.application.primaryports.mapper.commons.StatusDTOMapper;
import co.inventory.system.ld.application.usecase.commons.GetStatus;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class GetStatusInteractorImpl implements GetStatusInteractor {

    private final GetStatus getStatus;

    public GetStatusInteractorImpl(GetStatus getStatus) {
        this.getStatus = getStatus;
    }

    @Override
    public List<StatusDTO> execute(StatusDTO data) {
        var statusDomain = StatusDTOMapper.INSTANCE.toDomain(data);
        var results = getStatus.execute(statusDomain);
        return StatusDTOMapper.INSTANCE.toDTOCollection(results);
    }

}
