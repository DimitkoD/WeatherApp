package com.example.springbootproject.NEW.Domain.Service.Implementation;

import com.example.springbootproject.NEW.Domain.Service.GetResponseTemplateProvider;
import com.example.springbootproject.NEW.API.Model.GetResponse;
import org.springframework.stereotype.Service;

@Service
public class GetResponseProviderImpl implements GetResponseTemplateProvider {
    @Override
    public GetResponse getResponse() {
        return new GetResponse();
    }
}
