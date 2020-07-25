package com.lucifier.app.rest;

import com.lucifier.app.entity.Products;
import com.lucifier.app.indexer.ProductIndexer;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/indexer")
public class IndexerController {

  @Autowired
  ProductIndexer productIndexer;

  @PostMapping("/products")
  public ResponseEntity<Products> indexProduct(@RequestBody Products products) {
    try {
      productIndexer.index(products.getProducts());
    } catch (IOException e) {
      return ResponseEntity.unprocessableEntity().body(null);
    }
    return ResponseEntity.ok().body(products);
  }
}


