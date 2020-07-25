package com.lucifier.indexer;

import com.lucifier.entity.Product;
import java.io.IOException;
import java.util.List;

public interface Indexer {
   void index(List<Product> products) throws IOException;
}
