package com.lucifier.app.rest;

import com.lucifier.app.entity.Product;
import com.lucifier.app.entity.Products;
import com.lucifier.app.searcher.ProductSearcher;
import com.lucifier.app.searcher.querier.Field;
import com.lucifier.app.searcher.querier.FieldValue;
import com.lucifier.app.searcher.querier.SearchQuery;
import com.lucifier.app.searcher.querier.Value;
import java.io.IOException;
import java.util.List;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/searcher")
public class SearchController {

  @Autowired
  ProductSearcher productSearcher;

  @GetMapping("/products/query/{query}")
  public ResponseEntity<Products> indexProduct(@PathVariable String query)
      throws IOException, ParseException {
    List<Product> products = productSearcher
        .search(SearchQuery.builder()
            .fieldValue(
                FieldValue.builder()
                    .field(Field.builder().field("title").build())
                    .value(Value.builder().value(query).build())
                    .build()).build());
    return ResponseEntity.ok().body(Products.builder().products(products).build());
  }
}
