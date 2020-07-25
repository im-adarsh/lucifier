package com.lucifier.app.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/healthcheck")
public class HealthcheckController {

  @GetMapping("")
  public ResponseEntity<String> healthcheck() {
    return ResponseEntity.ok().body("healthy as f***");
  }
}
