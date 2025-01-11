package edu.duan.app.google.controller;

import edu.duan.app.google.api.board.column.EntryDTO;
import edu.duan.app.google.api.board.column.SearchResponse;
import edu.duan.app.google.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<SearchResponse> search(@RequestParam(name = "query") String query) {
        List<EntryDTO> results = searchService.performSearch(query);

        SearchResponse response = new SearchResponse(results);

        return ResponseEntity.ok(response);
    }
}
