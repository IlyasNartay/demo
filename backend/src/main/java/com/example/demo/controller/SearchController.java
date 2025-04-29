package com.example.demo.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final ElasticsearchClient elasticsearchClient;

    public SearchController(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @GetMapping
    public List<String> search(@RequestParam String keyword) throws IOException {
        SearchRequest request = SearchRequest.of(s -> s
                .index("products")
                .query(q -> q
                        .match(m -> m
                                .field("name")
                                .query(keyword)
                        )
                )
        );

        SearchResponse<Object> response = elasticsearchClient.search(request, Object.class);

        return response.hits().hits().stream()
                .map(Hit::source)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
