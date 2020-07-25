package com.lucifier.app.indexer;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class RootIndexer {

  Directory memoryIndex;
  StandardAnalyzer analyzer;


  RootIndexer() {
    memoryIndex = new RAMDirectory();
    analyzer = new StandardAnalyzer();
  }
}
