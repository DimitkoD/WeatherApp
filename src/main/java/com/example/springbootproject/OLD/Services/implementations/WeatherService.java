package com.example.springbootproject.OLD.Services.implementations;

import com.example.springbootproject.OLD.DomainModel.Coordinates;
import com.example.springbootproject.OLD.RequestModel.WeatherRequest.WeatherApiResponse;
import com.example.springbootproject.OLD.DomainModel.Weather;
import com.example.springbootproject.OLD.Services.RestTemplateProvider;
import com.example.springbootproject.OLD.Services.WeatherServices;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Primary
public class WeatherService implements WeatherServices {
    public final RestTemplateProvider restTemplateProvider;

    public WeatherService(RestTemplateProvider restTemplateProvider) {
        this.restTemplateProvider = restTemplateProvider;
        System.out.println("Weather impl has been created");
    }

    @RequestMapping("/weather")
    public Weather getMyWeather(Coordinates coordinates) {
        String url = "http://api.weatherapi.com/v1/current.json?key=b293c88263e5412089290227220807&q=" + coordinates.getLatitude() + "," + coordinates.getLongitude() + "&aqi=no";
        //HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        WeatherApiResponse weather = restTemplateProvider.
                getRestTemplate().getForObject(url, WeatherApiResponse.class);
        assert weather != null;
        return Weather.builder().
                location(weather.location.name).
                temperature(weather.current.temp_c).
                sky(weather.current.condition.text).percentHumidity(weather.current.humidity).
                build();
    }
}
