package com.exchange.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class calculatorRestController {

  private final CalculatorService calculatorService;

  public calculatorRestController(CalculatorService calculatorService) {
    this.calculatorService = calculatorService;
  }

  @GetMapping
  public String get() {
    calculatorService.get();
    return "get";
  }
}
