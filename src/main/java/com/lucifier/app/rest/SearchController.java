package com.lucifier.app.rest;

import com.lucifier.app.entity.Product;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/searcher")
public class SearchController {

  @PostMapping("/products/query/{query}")
  public ResponseEntity<List<Product>> indexProduct(@PathVariable String query) {
    return ResponseEntity.ok().body(null);
  }
}
