package pl.wposlednicka.weatherforecast.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wposlednicka.weatherforecast.model.WeatherDetailsOpenMeteoDTO;

@FeignClient(value = "openMeteoApiClient", url = "${open.meteo.url}")
public interface OpenMeteoApiClient {

    @GetMapping(value = "/forecast")
    WeatherDetailsOpenMeteoDTO getWeatherDetails(@RequestParam("latitude") Double latitude,
                                                 @RequestParam("longitude") Double longitude,
                                                 @RequestParam("daily") String daily,
                                                 @RequestParam("past_days") String pastDays,
                                                 @RequestParam("forecast_days") String forecastDays,
                                                 @RequestParam("timezone") String timezone);

}

