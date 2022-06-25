package com.exchange.calculator.exception;

import com.exchange.calculator.exception.custom.CountryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CountryNotFoundException.class)
  public ResponseEntity<String> countryNotFoundExceptionHandler() {
    final String errorMessage = "국가 정보를 찾을 수 없습니다";
    return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
