package com.upc.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.model.WeatherResponse;
import com.upc.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by  waiter on 18-11-25  下午1:11.
 *
 * @author waiter
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    private final static Logger LOG= LoggerFactory.getLogger(WeatherServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    private final Long TIME_OUT = 1800L;
    private final String WEATHER_API="http://wthrcdn.etouch.cn/weather_mini";
    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url = WEATHER_API + "?citykey="+cityId;
        return doGetWeatherData(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url = WEATHER_API + "?city="+cityName;
        return doGetWeatherData(url);
    }

    @Async
    @Override
    public void syncDataByCityId(String cityId) {
        //LOG.info("开始同步"+cityId+"天气");
        String url = WEATHER_API + "?citykey="+cityId;
        saveWeatherData(url);
        //LOG.info("结束同步"+cityId+"天气");
    }

    @Async
    @Override
    public void syncDataByCityName(String cityName) {
        //LOG.info("开始同步"+cityName+"天气");
        String url = WEATHER_API + "?city="+cityName;
        saveWeatherData(url);
        //LOG.info("结束同步"+cityName+"天气");
    }


    private void saveWeatherData(String url){
        WeatherResponse weatherResponse=null;
        ResponseEntity<String> response =
                restTemplate.getForEntity(url, String.class);
        String body = null;
        if (response.getStatusCodeValue() == 200) {
            body = response.getBody();
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            weatherResponse = mapper.readValue(body, WeatherResponse.class);
            ValueOperations ops = redisTemplate.opsForValue();
            ops.set(url, weatherResponse, TIME_OUT, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private WeatherResponse doGetWeatherData(String url){
        ValueOperations ops = redisTemplate.opsForValue();
        return  (WeatherResponse) ops.get(url);
    }

}
