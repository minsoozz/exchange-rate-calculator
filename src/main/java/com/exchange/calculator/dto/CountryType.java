package com.exchange.calculator.dto;

public enum CountryType {

  KOREA("USDKRW"),
  JAPAN("USDJPY"),
  PHILIPPINE("USDPHP");

  private final String quote;

  CountryType(String quote) {
    this.quote = quote;
  }

  public String getQuote() {
    return quote;
  }
}
