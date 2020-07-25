package com.lucifier.rest;

import com.lucifier.entity.Product;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/searcher")
public class SearchController {

  @PostMapping("/products")
  public ResponseEntity<List<Product>> indexProduct(@RequestBody List<Product> products) {
    return ResponseEntity.ok().body(products);
  }
}
