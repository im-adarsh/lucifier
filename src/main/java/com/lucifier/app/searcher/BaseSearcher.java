package com.lucifier.app.searcher;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.springframework.stereotype.Component;

@Component
public class BaseSearcher {


  Directory memoryIndex;
  StandardAnalyzer analyzer;


  BaseSearcher() {
    analyzer = new StandardAnalyzer();
  }
}
