package edu.duan.app.google.repository;

import edu.duan.app.google.model.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EntryRepository extends JpaRepository<EntryEntity, Long> {
    @Query(value = "SELECT * FROM entry WHERE entry.title ILIKE CONCAT('%', :query, '%') OR entry.short_body ILIKE CONCAT('%', :query, '%')", nativeQuery = true)
    List<EntryEntity> findAllByTitleOrBody(@Param("query") String query);
}