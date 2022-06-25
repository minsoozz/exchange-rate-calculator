package com.exchange.calculator.service;

import com.exchange.calculator.dto.CountryType;
import com.exchange.calculator.exception.custom.CountryNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Service
public class CalculatorService {

  private final ApiResponseService apiResponseService;

  public CalculatorService(ApiResponseService apiResponseService) {
    this.apiResponseService = apiResponseService;
  }


  public Double getExchangeRateByCountry(String country) {
    try {
      return apiResponseService.getExchangeRate().get(CountryType.valueOf(country).getQuote());
    } catch (IllegalArgumentException e) {
      throw new CountryNotFoundException("국가 정보를 찾을 수 없습니다");
    }
  }

  public String exchangeCalculator(Double exchangeRate, Double remittanceAmount) {
    BigDecimal bigDecimalExchangeRate= new BigDecimal(exchangeRate);
    BigDecimal bigDecimalRemittanceAmount = new BigDecimal(remittanceAmount);
    BigDecimal multiplyResult = bigDecimalExchangeRate.multiply(bigDecimalRemittanceAmount);
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###.00");
    return decimalFormat.format(multiplyResult);
  }
}
