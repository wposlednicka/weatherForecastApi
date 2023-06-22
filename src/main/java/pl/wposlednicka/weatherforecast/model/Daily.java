package pl.wposlednicka.weatherforecast.model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Daily {

    private List<LocalDateTime> sunrise;
    private List<LocalDateTime> sunset;
    private List<Double> precipitation_sum;

}
