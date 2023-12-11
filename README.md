
# Weather API

Приложение предоставляет даные о текущей погоде по городу Минск. В качестве API используется ресурс:

 https://rapidapi.com/ru/weatherapi/api/weatherapi-com/

В приложение так же можно запросить данные по заданному диапозону дней. Обмен информации между ресурсом, моим приложением и выводом её пользователю осуществляется с использовании формата JSON. 



## Features
- Каждые 10 минут сохраняет данные о текущею погоде в базу данных;
- Частоту запроса данных можно изменить
(В файле application.properties по адресу /src/main/resources/ переменная fixed.rates="тут вводите ваш интервал в формате длительности ISO");
- При использовании GET-запроса "/api/currentWeather" выводит данные текущей погоде в JSON формате;
- При использовании GET-запроса "/api/averageWeather" и ввода диапозона дат в формате :  
{

“from”: “2023-12-01”,

“to”: “2023-12-07” 

  }   

Выводит средние значение данных за указанный период. Используйте диапозон дат не превышающий более 9 дней с даты отправки GET-запроса. Бесплатная подписка больше не позволяет :)




## API Reference

#### Get current weather

```http
  GET /api/currentWeather
```


#### Get average weather from "YYYY-MM-DD" , to "YYYY-MM-DD"

```http
  GET /api/averageWeather
```

| Parameter | Type     | Description              |
|:----------|:---------|:-------------------------|
| `from`    | `string` | **Required**. Date start |
| `to`      | `string` | **Required**. Date end   |

## Tools for Creating 

Для создания приложения использовал :

- Spring Web WEB
  
Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
- Spring Data JPA SQL

Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
- MySQL Driver SQL
  
MySQL JDBC driver.







- SQL sqript для создания Data Base : 
```http

CREATE DATABASE  weather_api;

USE weather_api;



CREATE TABLE weather (

  id BIGINT NOT NULL AUTO_INCREMENT,

  temperature FLOAT,

  wind_speed FLOAT,

  air_pressure FLOAT,

  air_humidity BIGINT,

  weather_condition VARCHAR(50),

  location VARCHAR(20),

  PRIMARY KEY (id)

);
```
