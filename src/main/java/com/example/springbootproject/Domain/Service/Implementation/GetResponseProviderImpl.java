package com.example.springbootproject.Domain.Service.Implementation;

import com.example.springbootproject.API.Model.GetResponse;
import com.example.springbootproject.Domain.Service.GetResponseTemplateProvider;
import org.springframework.stereotype.Service;

@Service
public class GetResponseProviderImpl implements GetResponseTemplateProvider {
    @Override
    public GetResponse getResponse() {
        return new GetResponse();
    }
}
