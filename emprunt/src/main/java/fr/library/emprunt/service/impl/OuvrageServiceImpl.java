package fr.library.emprunt.service.impl;

import fr.library.emprunt.model.OuvrageEntity;
import fr.library.emprunt.repository.OuvrageRepository;
import fr.library.emprunt.service.OuvrageService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OuvrageServiceImpl extends CrudServiceImpl<OuvrageEntity, Long> implements OuvrageService {
    private final OuvrageRepository ouvrageRepository;

    public OuvrageServiceImpl(OuvrageRepository ouvrageRepository) {
        this.ouvrageRepository = ouvrageRepository;
    }

    @Override
    public OuvrageRepository getRepository() {
        return ouvrageRepository;
    }

    @Override
    public List<OuvrageEntity> findBySearch(String search) {
        if (Strings.isBlank(search)) {
            return findAll();
        }
        List<String> words = Arrays.stream(search.trim().toLowerCase().split("\\s+")).map(String::trim).collect(Collectors.toList());
        return getRepository().findAll(forWords(words));
    }

    private Specification<OuvrageEntity> forWords(List<String> words) {
        if (CollectionUtils.isEmpty(words)) {
            throw new RuntimeException("List of words cannot be empty.");
        }
        return (root, query, builder) -> words.stream()
                .map(String::toLowerCase)
                .map(word -> "%" + word + "%")
                .map(word -> builder.like(builder.lower(root.get("titre")), word))
                .reduce(builder::or)
                .get();
    }
}
