package pl.wposlednicka.weatherforecast.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherDetailsOpenMeteoDTO {

    private Daily daily;

}
