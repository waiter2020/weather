package com.upc.controller;

import com.upc.model.WeatherResponse;
import com.upc.service.WeatherService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by  waiter on 18-11-25  下午1:40.
 *
 * @author waiter
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable String cityId){
        return weatherService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName")
    public WeatherResponse getWeatherByCityName(@RequestParam String cityName){
        return weatherService.getDataByCityName(cityName);
    }
}
