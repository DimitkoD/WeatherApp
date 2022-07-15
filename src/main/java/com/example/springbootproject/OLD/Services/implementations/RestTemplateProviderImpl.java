package com.example.springbootproject.OLD.Services.implementations;

import com.example.springbootproject.OLD.Services.RestTemplateProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateProviderImpl implements RestTemplateProvider {
    public RestTemplateProviderImpl() {
        System.out.println("RestTemplateImpl has been created");
    }

    @Override
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
