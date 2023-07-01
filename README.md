# weatherForecastApi

Aplikacja serwerowa z wykorzystaniem frameworka Spring (Spring Boot) serwującej użytkownikowi historyczne (miniony tydzień) dane meteorologiczne z publicznego API (https://open-meteo.com). 
Serwer powinien wystawiać endpoint akceptujący długość i szerokość geograficzną. 
Zwracane informacje muszą zawierać w sobie średnią ilość opadów danego dnia oraz czas wschodu/zachodu słońca. 
Aplikacja powinna każdorazowo zapisywać w relacyjnej bazie danych czas oraz parametry wywołania endpointu. 
