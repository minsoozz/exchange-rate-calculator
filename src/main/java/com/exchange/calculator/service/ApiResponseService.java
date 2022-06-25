package com.exchange.calculator.service;

import com.exchange.calculator.dto.CalculatorDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Objects;

@Service
public class ApiResponseService {

  private final RestTemplate restTemplate;

  public ApiResponseService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Value("${calculator.url}")
  private String url;

  @Value("${calculator.accessKey}")
  private String accessKey;

  public Map<String,Double> getExchangeRate() {

    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url).queryParam("access_key", accessKey);
    return Objects.requireNonNull(restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                getHttpEntity(),
                CalculatorDto.class)
            .getBody())
        .getQuotes();
  }

  private HttpEntity<HttpHeaders> getHttpEntity() {
    return new HttpEntity<>(getHttpHeaders());
  }

  private HttpHeaders getHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
  }
}
