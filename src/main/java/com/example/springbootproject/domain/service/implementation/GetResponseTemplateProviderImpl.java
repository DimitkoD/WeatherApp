package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.domain.service.GetResponseTemplateProvider;
import com.example.springbootproject.api.model.GetResponse;
import org.springframework.stereotype.Service;

@Service
public class GetResponseTemplateProviderImpl implements GetResponseTemplateProvider {
    @Override
    public GetResponse getResponse() {
        return new GetResponse();
    }
}
