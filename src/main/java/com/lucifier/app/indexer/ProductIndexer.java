package com.lucifier.app.indexer;

import com.lucifier.app.constant.Fields;
import com.lucifier.app.entity.Product;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Component;

@Component
public class ProductIndexer extends BaseIndexer implements Indexer {


  @Override
  public void index(List<Product> products) throws IOException {

    memoryIndex = FSDirectory.open(new File("indexdata").toPath());

    IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
    IndexWriter writer = new IndexWriter(memoryIndex, indexWriterConfig);
    for (Product p : products) {
      Document document = new Document();
      document.add(new TextField(Fields.ID, p.getId(), Field.Store.YES));
      document.add(new TextField(Fields.TITLE, p.getTitle(), Field.Store.YES));
      document.add(new TextField(Fields.DESCRIPTION, p.getDescription(), Field.Store.YES));
      writer.addDocument(document);
    }
    writer.close();
  }
}
