package com.upc.service;

import com.upc.model.Weather;

/**
 * Created by  waiter on 18-11-26  下午4:58.
 *
 * @author waiter
 */
public interface WeatherReportService {
    Weather getDataByCityId(String cityId);
}
