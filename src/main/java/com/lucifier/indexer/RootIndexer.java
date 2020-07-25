package com.lucifier.indexer;

import java.io.IOException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class RootIndexer {

  Directory memoryIndex;
  StandardAnalyzer analyzer;
  IndexWriterConfig indexWriterConfig;

  RootIndexer()  {
     memoryIndex = new RAMDirectory();
     analyzer = new StandardAnalyzer();
     indexWriterConfig = new IndexWriterConfig(analyzer);
  }
}
