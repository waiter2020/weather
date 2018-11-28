package com.upc.service;

import com.upc.model.City;
import com.upc.model.ProvinceList;

import java.util.List;

/**
 * Created by  waiter on 18-11-25  下午5:40.
 *
 * @author waiter
 */
public interface CityDataService {
    ProvinceList listCity() throws Exception;
}
