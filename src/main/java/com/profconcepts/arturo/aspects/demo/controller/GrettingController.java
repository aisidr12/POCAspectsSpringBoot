package com.profconcepts.arturo.aspects.demo.controller;

import com.profconcepts.arturo.aspects.demo.services.GrettingService;
import java.util.Collections;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class GrettingController {

  private final GrettingService grettingService;

  public GrettingController(GrettingService grettingService) {
    this.grettingService = grettingService;
  }

  @GetMapping("/gretting")
  public ResponseEntity<?> getGretting() {
    return ResponseEntity.ok(
        Collections.singletonMap("gretting", grettingService.sayHello("Arturo", "Hello how are you")));
  }

}
