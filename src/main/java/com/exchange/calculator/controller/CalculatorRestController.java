package com.exchange.calculator.controller;

import com.exchange.calculator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculators")
public class CalculatorRestController {

  private final CalculatorService calculatorService;

  public CalculatorRestController(CalculatorService calculatorService) {
    this.calculatorService = calculatorService;
  }

  @GetMapping
  public ResponseEntity<Double> get(@RequestParam String country) {
    return ResponseEntity.ok(calculatorService.getExchangeRateByCountry(country));
  }

  @GetMapping("/exchange")
  public ResponseEntity<String> exchange(@RequestParam Double exchangeRate, @RequestParam Double remittanceAmount){
    return ResponseEntity.ok(calculatorService.exchangeCalculator(exchangeRate,remittanceAmount));
  }
}
