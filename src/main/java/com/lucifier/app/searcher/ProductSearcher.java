package com.lucifier.app.searcher;

import com.lucifier.app.entity.Product;
import com.lucifier.app.searcher.querier.SearchQuery;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Component;

@Component
public class ProductSearcher extends BaseSearcher implements Searcher {

  @Override
  public List<Product> search(SearchQuery q) throws IOException, ParseException {
    memoryIndex = FSDirectory.open(new File("indexdata").toPath());

    Query query = new QueryParser(q.getFieldValue().getField().getField(),
        analyzer)
        .parse(q.getFieldValue().getValue().getValue());

    IndexReader indexReader = DirectoryReader.open(memoryIndex);
    IndexSearcher searcher = new IndexSearcher(indexReader);
    TopDocs topDocs = searcher.search(query, 10);

    List<Product> products = new ArrayList<>();
    for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
      Document doc = (searcher.doc(scoreDoc.doc));
      doc.getFields().forEach(f -> {
        if (q.getFieldValue().getField().getField().equals(f.name())) {
          products.add(Product.builder().title(f.stringValue()).build());
        }
      });
    }

    return products;
  }
}
