package com.lucifier.app.indexer;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.stereotype.Component;

@Component
public class BaseIndexer {

  Directory memoryIndex;
  StandardAnalyzer analyzer;


  BaseIndexer() {
    memoryIndex = new RAMDirectory();
    analyzer = new StandardAnalyzer();
  }
}
