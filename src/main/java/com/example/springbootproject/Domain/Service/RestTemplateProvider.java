package com.example.springbootproject.Domain.Service;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateProvider {
    RestTemplate getRestTemplate();
}
