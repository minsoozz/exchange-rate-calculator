package com.exchange.calculator.dto;

import java.util.List;

public class CalculatorDto {
  private boolean success;
  private Quote quotes;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public Quote getQuotes() {
    return quotes;
  }

  public void setQuotes(Quote quotes) {
    this.quotes = quotes;
  }
}
