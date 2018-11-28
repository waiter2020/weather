package com.upc.service.impl;

import com.upc.model.City;

import com.upc.model.ProvinceList;
import com.upc.service.CityDataService;
import com.upc.util.XmlBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by  waiter on 18-11-25  下午5:41.
 *
 * @author waiter
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Cacheable(value = "cityList", key = "#root.targetClass ", unless = "#result eq null")
    @Override
    public ProvinceList listCity() throws Exception {
        ClassPathResource resource = new ClassPathResource("city-list.xml");
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(resource.getInputStream(),
                                StandardCharsets.UTF_8));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        while ((line = reader.readLine())!=null){
            stringBuffer.append(line);
        }
        reader.close();

        return (ProvinceList) XmlBuilder.xmlStrToObject(ProvinceList.class, stringBuffer.toString());

    }
}
