package com.exchange.calculator.controller;

import com.exchange.calculator.dto.CalculatorDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CalculatorService {

  private final RestTemplate restTemplate;

  public CalculatorService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Value("${calculator.url}")
  private String url;

  @Value("${calculator.accessKey}")
  private String accessKey;

  public void get() {

    HttpHeaders headers = new HttpHeaders();
    HttpEntity request = new HttpEntity(headers);

    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url).queryParam("access_key", accessKey);
    System.out.println(uriBuilder.toUriString());
    restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, request, CalculatorDto.class);
  }
}
