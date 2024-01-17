package pl.wposlednicka.weatherforecast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.wposlednicka.weatherforecast.entities.WeatherDetailsEntity;
import pl.wposlednicka.weatherforecast.model.WeatherDetailsOpenMeteoDTO;
import pl.wposlednicka.weatherforecast.model.WeatherDetailsDTO;
import pl.wposlednicka.weatherforecast.repository.WeatherForecastRepository;
import pl.wposlednicka.weatherforecast.utils.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeatherForecastService {

    @Value("${open.meteo.url}")
    private String OPEN_METEO_URL;
    private static final String SEVEN = "7";
    private static final String DAILY = "sunrise,sunset,precipitation_sum";
    private static final String ZERO = "0";
    private static final String TIMEZONE = "auto";

    @Autowired
    private WeatherForecastRepository weatherForecastRepository;

    private OpenMeteoApiClient openMeteoApiClient;

    public WeatherForecastService(OpenMeteoApiClient openMeteoApiClient) {
        this.openMeteoApiClient = openMeteoApiClient;
    }

    public  List<WeatherDetailsDTO> getPastDaysWeatherDetailsByLatitudeAndLongitude(Double latitude, Double longitude) {
        saveWeatherDetails(latitude, longitude);
        List<WeatherDetailsDTO> weatherDetailsDTO = getWeatherDetailsDTOS(latitude, longitude);
        return weatherDetailsDTO;
    }

    private List<WeatherDetailsDTO> getWeatherDetailsDTOS(Double latitude, Double longitude) {
        WeatherDetailsOpenMeteoDTO weatherDetailsOpenMeteoDTO = getWeatherDetailsFromOpenMeteo(latitude, longitude);
        List<WeatherDetailsDTO> weatherDetailsDTO = Mapper.mapToWeatherDetailsDTOList(weatherDetailsOpenMeteoDTO);
        return weatherDetailsDTO;
    }

    private void saveWeatherDetails(Double latitude, Double longitude){
        WeatherDetailsEntity weatherDetailsEntity = createWeatherDetails(latitude, longitude);
        weatherForecastRepository.save(weatherDetailsEntity);
    }

    private WeatherDetailsEntity createWeatherDetails(Double latitude, Double longitude) {
        WeatherDetailsEntity weatherDetails = new WeatherDetailsEntity();
        weatherDetails.setLatitude(latitude);
        weatherDetails.setLongitude(longitude);
        weatherDetails.setRequestDate(LocalDateTime.now());
        return weatherDetails;
    }

    private WeatherDetailsOpenMeteoDTO getWeatherDetailsFromOpenMeteo(Double latitude, Double longitude) {
        return openMeteoApiClient.getWeatherDetails(latitude, longitude, DAILY, SEVEN, ZERO, TIMEZONE);
    }

    private WeatherDetailsOpenMeteoDTO test(Double latitude, Double longitude) {
        return openMeteoApiClient.getWeatherDetails(latitude, longitude, DAILY, SEVEN, ZERO, TIMEZONE);
    }


}
