package fr.library.emprunt.service.impl;

import fr.library.emprunt.model.AbstractEntity;
import fr.library.emprunt.service.CrudService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CrudServiceImpl<T extends AbstractEntity, ID> implements CrudService<T, ID> {
    public abstract JpaRepository<T, ID> getRepository();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        return getRepository().findAllById(ids);
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        return getRepository().saveAll(entities);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }

    @Override
    public <S extends T> S saveAndFlush(S entity) {
        return getRepository().saveAndFlush(entity);
    }

    @Override
    public void deleteInBatch(Iterable<T> entities) {
        getRepository().deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch() {
        getRepository().deleteAllInBatch();
    }

    @Override
    public T getOne(ID id) {
        return getRepository().getOne(id);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return getRepository().findAll(example);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return getRepository().findAll(example, sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public <S extends T> S save(S entity) {
        return getRepository().saveAndFlush(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return getRepository().existsById(id);
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        getRepository().deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }
}
