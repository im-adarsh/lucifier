package com.lucifier.app.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {

  private String title;
  private String description;
}
