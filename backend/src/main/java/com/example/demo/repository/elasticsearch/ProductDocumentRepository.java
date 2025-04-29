
package com.example.demo.repository.elasticsearch;

import com.example.demo.model.elasticsearch.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDocumentRepository extends ElasticsearchRepository<ProductDocument, String> {
    List<ProductDocument> findByName(String name);
    List<ProductDocument> findByDescriptionContaining(String keyword);
}