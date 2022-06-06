package com.exchange.calculator.controller;

import com.exchange.calculator.dto.CalculatorDto;
import com.exchange.calculator.dto.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculatorService {

  @Value("${calculator.url}")
  private String url;

  @Value("${calculator.accessKey}")
  private String accessKey;

  public void get() {

  }
}
