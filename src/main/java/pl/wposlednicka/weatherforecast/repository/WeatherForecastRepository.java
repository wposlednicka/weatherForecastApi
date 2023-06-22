package pl.wposlednicka.weatherforecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wposlednicka.weatherforecast.entities.WeatherDetailsEntity;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherDetailsEntity, Long> {


}


