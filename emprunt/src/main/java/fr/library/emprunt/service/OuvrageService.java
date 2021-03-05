package fr.library.emprunt.service;

import fr.library.emprunt.model.OuvrageEntity;

import java.util.List;


public interface OuvrageService extends CrudService <OuvrageEntity, Long> {
    List<OuvrageEntity> findBySearch(String search);
}
