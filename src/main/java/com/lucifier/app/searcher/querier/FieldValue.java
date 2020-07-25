package com.lucifier.app.searcher.querier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldValue {

  private Field field;
  private Value value;
}
