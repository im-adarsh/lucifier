package com.lucifier.app.indexer;

import com.lucifier.app.entity.Product;
import java.io.IOException;
import java.util.List;

public interface Indexer {

  void index(List<Product> products) throws IOException;
}
