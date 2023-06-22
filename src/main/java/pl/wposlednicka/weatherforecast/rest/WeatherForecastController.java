package pl.wposlednicka.weatherforecast.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wposlednicka.weatherforecast.model.WeatherDetailsDTO;
import pl.wposlednicka.weatherforecast.services.WeatherForecastService;
import java.util.List;

@RestController
@RequestMapping("/weatherforecast")
public class WeatherForecastController {

    @Autowired
    private WeatherForecastService weatherForecastService;

    @GetMapping(value = "past/weatherdetails")
    public @ResponseBody List<WeatherDetailsDTO> getPastDaysWeatherDetailsByLatitudeAndLongitude(@RequestParam("latitude") Double latitude,
                                                                                                      @RequestParam("longitude") Double longitude) {
        List<WeatherDetailsDTO> sevenDaysWeatherDetails = weatherForecastService.getPastDaysWeatherDetailsByLatitudeAndLongitude(latitude, longitude);
        return sevenDaysWeatherDetails;
    }

}
