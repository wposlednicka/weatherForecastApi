package pl.wposlednicka.weatherforecast;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.wposlednicka.weatherforecast.model.Daily;
import pl.wposlednicka.weatherforecast.model.WeatherDetailsDTO;
import pl.wposlednicka.weatherforecast.model.WeatherDetailsOpenMeteoDTO;
import pl.wposlednicka.weatherforecast.utils.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
public class MapperTest {

    private WeatherDetailsOpenMeteoDTO weatherDetailsOpenMeteoDTO;

    @Before
    public void setUp(){
        weatherDetailsOpenMeteoDTO = new WeatherDetailsOpenMeteoDTO();
        Daily daily = new Daily();
        daily.setSunrise(createSunrisesList());
        daily.setSunset(createSunsetList());
        daily.setPrecipitation_sum(List.of(0.6, 0.0));
        weatherDetailsOpenMeteoDTO.setDaily(daily);
    }

    private List<LocalDateTime> createSunsetList(){
        LocalDateTime sunsetOne = LocalDateTime.parse("2023-06-15T21:33");
        LocalDateTime sunsetTwo = LocalDateTime.parse("2023-06-17T20:11");
        return List.of(sunsetOne, sunsetTwo);
    }

    private List<LocalDateTime> createSunrisesList(){
        LocalDateTime sunriseOne = LocalDateTime.parse("2023-06-15T04:33");
        LocalDateTime sunriseTwo = LocalDateTime.parse("2023-06-17T05:11");
        return List.of(sunriseOne, sunriseTwo);
    }

    @Test
    public void shouldMapperWeatherForecastOpenMeteoDTOtoWeatherForecastDTO(){
        List<WeatherDetailsDTO> weatherDetailsDTOS = Mapper.mapToWeatherDetailsDTOList(weatherDetailsOpenMeteoDTO);

        WeatherDetailsDTO weatherOne = weatherDetailsDTOS.get(0);
        Assert.assertEquals(weatherOne.getDate(), weatherDetailsOpenMeteoDTO.getDaily().getSunrise().get(0).toLocalDate());
        Assert.assertEquals(weatherOne.getSunrise(), weatherDetailsOpenMeteoDTO.getDaily().getSunrise().get(0).toLocalTime());
        Assert.assertEquals(weatherOne.getSunset(), weatherDetailsOpenMeteoDTO.getDaily().getSunset().get(0).toLocalTime());
        Assert.assertEquals(weatherOne.getPrecipitation(), weatherDetailsOpenMeteoDTO.getDaily().getPrecipitation_sum().get(0));

        WeatherDetailsDTO weatherTwo = weatherDetailsDTOS.get(1);
        Assert.assertEquals(weatherTwo.getDate(), weatherDetailsOpenMeteoDTO.getDaily().getSunrise().get(1).toLocalDate());
        Assert.assertEquals(weatherTwo.getSunrise(), weatherDetailsOpenMeteoDTO.getDaily().getSunrise().get(1).toLocalTime());
        Assert.assertEquals(weatherTwo.getSunset(), weatherDetailsOpenMeteoDTO.getDaily().getSunset().get(1).toLocalTime());
        Assert.assertEquals(weatherTwo.getPrecipitation(), weatherDetailsOpenMeteoDTO.getDaily().getPrecipitation_sum().get(1));
    }
}
