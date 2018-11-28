package com.upc.service;

import com.upc.model.WeatherResponse;

/**
 * Created by  waiter on 18-11-25  下午1:10.
 *
 * @author waiter
 */
public interface WeatherService {
    WeatherResponse getDataByCityId(String cityId);
    WeatherResponse getDataByCityName(String cityName);

    void syncDataByCityId(String cityId);
    void syncDataByCityName(String cityName);
}
