package com.lucifier.app.searcher;

import com.lucifier.app.entity.Product;
import com.lucifier.app.searcher.querier.SearchQuery;
import java.io.IOException;
import java.util.List;
import org.apache.lucene.queryparser.classic.ParseException;

public interface Searcher {

  List<Product> search(SearchQuery query) throws IOException, ParseException;
}
