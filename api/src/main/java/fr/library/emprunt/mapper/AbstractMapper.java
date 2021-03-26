package fr.library.emprunt.mapper;

import fr.library.emprunt.dto.AbstractDTO;
import fr.library.emprunt.model.AbstractEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMapper<E extends AbstractEntity, D extends AbstractDTO> {
    public abstract D toDTO(E entity);

    public abstract E toEntity(D dto);

    public List<D> toDTOs(Collection<E> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<E> toEntities(Collection<D> dtos) {
        if (CollectionUtils.isEmpty(dtos)) {
            return Collections.emptyList();
        }
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
