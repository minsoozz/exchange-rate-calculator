package com.exchange.calculator.dto;

import java.util.HashMap;
import java.util.Map;

public class CalculatorDto {
  private boolean success;
  private Map<String,Double> quotes = new HashMap<>();

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public Map<String, Double> getQuotes() {
    return quotes;
  }

  public void setQuotes(Map<String, Double> quotes) {
    this.quotes = quotes;
  }

  @Override
  public String toString() {
    return "CalculatorDto{" +
        "success=" + success +
        ", quote=" + quotes +
        '}';
  }
}
