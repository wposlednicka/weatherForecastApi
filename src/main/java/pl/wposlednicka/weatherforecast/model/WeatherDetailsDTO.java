package pl.wposlednicka.weatherforecast.model;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherDetailsDTO {

    private LocalDate date;
    private LocalTime sunrise;
    private LocalTime sunset;
    private Double precipitation;
}
