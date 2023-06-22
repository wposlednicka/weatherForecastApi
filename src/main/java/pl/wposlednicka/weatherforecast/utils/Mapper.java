package pl.wposlednicka.weatherforecast.utils;

import pl.wposlednicka.weatherforecast.model.WeatherDetailsDTO;
import pl.wposlednicka.weatherforecast.model.WeatherDetailsOpenMeteoDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static List<WeatherDetailsDTO> mapToWeatherDetailsDTOList(WeatherDetailsOpenMeteoDTO weatherDetailsOpenMeteoDTO) {
        List<WeatherDetailsDTO> weatherDetailsDTOS = new ArrayList<>();

        int size = weatherDetailsOpenMeteoDTO.getDaily().getSunrise().size();

        for(int i = 0; i < size; i++){
            WeatherDetailsDTO weatherDetailsDTO = new WeatherDetailsDTO();
            LocalDateTime localDateAndTimeSunrise = weatherDetailsOpenMeteoDTO.getDaily().getSunrise().get(i);

            weatherDetailsDTO.setDate(localDateAndTimeSunrise.toLocalDate());
            weatherDetailsDTO.setSunrise(localDateAndTimeSunrise.toLocalTime());

            LocalDateTime localDateAndTimeSunset = weatherDetailsOpenMeteoDTO.getDaily().getSunset().get(i);
            weatherDetailsDTO.setSunset(localDateAndTimeSunset.toLocalTime());

            Double precipitationString = weatherDetailsOpenMeteoDTO.getDaily().getPrecipitation_sum().get(i);
            weatherDetailsDTO.setPrecipitation(precipitationString);

            weatherDetailsDTOS.add(weatherDetailsDTO);
        }
        return weatherDetailsDTOS;
    }
}
