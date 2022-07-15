package com.example.springbootproject.domain.service;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateProvider {
    RestTemplate getRestTemplate();
}
