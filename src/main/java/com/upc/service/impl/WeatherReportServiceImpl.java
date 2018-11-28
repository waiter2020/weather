package com.upc.service.impl;

import com.upc.model.Weather;
import com.upc.service.WeatherReportService;
import com.upc.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by  waiter on 18-11-26  下午4:59.
 *
 * @author waiter
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherService weatherService;

    @Override
    public Weather getDataByCityId(String cityId) {
        return weatherService.getDataByCityId(cityId).getData();
    }
}
