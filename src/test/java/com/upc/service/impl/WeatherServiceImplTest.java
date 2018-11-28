package com.upc.service.impl;

import com.upc.model.City;
import com.upc.model.ProvinceList;
import com.upc.service.CityDataService;
import com.upc.service.WeatherService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/** 
* WeatherServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>十一月 25, 2018</pre> 
* @version 1.0 
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class WeatherServiceImplTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getDataByCityId(String cityId) 
* 
*/
    @Autowired
    private WeatherService weatherService;
@Test
public void testGetDataByCityId() throws Exception { 
//TODO: Test goes here...
    System.out.println(weatherService.getDataByCityName("青岛"));
} 

/** 
* 
* Method: getDataByCityName(String cityName) 
* 
*/
@Autowired
private CityDataService cityDataService;
@Test
public void testGetDataByCityName() throws Exception { 
//TODO: Test goes here...
    ProvinceList cities = cityDataService.listCity();
    System.out.println(cities);
} 


/** 
* 
* Method: doGetWeatherData(String url) 
* 
*/ 
@Test
public void testDoGetWeatherData() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = WeatherServiceImpl.getClass().getMethod("doGetWeatherData", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
