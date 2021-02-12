package fr.library.emprunt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDTO {
    private Long id;

    public AbstractDTO(Long id) {
        this.id = id;
    }

    public AbstractDTO() {
    }
}
