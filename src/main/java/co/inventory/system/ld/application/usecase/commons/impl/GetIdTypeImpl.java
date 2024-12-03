package co.inventory.system.ld.application.usecase.commons.impl;

import co.inventory.system.ld.application.secondaryports.mapper.commons.IdTypeEntityMapper;
import co.inventory.system.ld.application.secondaryports.repository.commons.IdTypeRepository;
import co.inventory.system.ld.application.usecase.commons.GetIdType;
import co.inventory.system.ld.domain.commons.IdTypeDomain;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GetIdTypeImpl implements GetIdType {

    private final IdTypeRepository idTypeRepository;

    public GetIdTypeImpl(IdTypeRepository idTypeRepository) {
        this.idTypeRepository = idTypeRepository;
    }

    @Override
    public List<IdTypeDomain> execute(IdTypeDomain domain) {
        var idTypeEntity = IdTypeEntityMapper.INSTANCE.toEntity(domain);
        var results = idTypeRepository.findByFilter(idTypeEntity);
        return IdTypeEntityMapper.INSTANCE.toDomainCollection(results);
    }
}
