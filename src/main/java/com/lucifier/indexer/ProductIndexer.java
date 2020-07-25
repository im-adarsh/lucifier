package com.lucifier.indexer;

import com.lucifier.entity.Product;
import java.io.IOException;
import java.util.List;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;

public class ProductIndexer extends RootIndexer implements Indexer {


  @Override
  public void index(List<Product> products) throws IOException {

    IndexWriter writer = new IndexWriter(memoryIndex, indexWriterConfig);

    for (Product p: products) {
      Document document = new Document();
      document.add(new TextField("title", p.getTitle(), Field.Store.YES));
      document.add(new TextField("body", p.getDescription(), Field.Store.YES));
      writer.addDocument(document);
    }
    writer.close();
  }
}
