package edu.duan.app.google.service;

import edu.duan.app.google.api.board.column.EntryDTO;
import edu.duan.app.google.model.EntryEntity;
import edu.duan.app.google.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class SearchService {

    private final EntryRepository entryRepository;

    @Autowired
    public SearchService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<EntryDTO> performSearch(String query) {
        if (query == null || query.isEmpty())
            return Collections.emptyList();

        return mapToDTO(entryRepository.findAllByTitleOrBody(query));
    }

    private List<EntryDTO> mapToDTO(List<EntryEntity> entryEntities) {
        if (entryEntities == null || entryEntities.isEmpty())
            return Collections.emptyList();

        return entryEntities.stream()
                .map(entryEntity ->
                        new EntryDTO(
                                entryEntity.getTitle(),
                                entryEntity.getShortBody()
                        )
                ).toList();
    }
}