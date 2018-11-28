package com.upc.controller;

import com.upc.model.City;
import com.upc.model.Prefecture;
import com.upc.model.Province;
import com.upc.service.CityDataService;
import com.upc.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by  waiter on 18-11-26  下午5:01.
 *
 * @author waiter
 */
@Controller
@RequestMapping("/report")
public class WeatherReportController {
    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping({"/cityId/{cityId}","/cityId"})
    public String getReportByCityId(@PathVariable(required = false) String cityId, Model model) throws Exception {
        if (cityId==null){
            cityId="101120201";
        }

        model.addAttribute("title","老韦的天气预报");
        model.addAttribute("cityId",cityId.substring(3));
        model.addAttribute("provincess",cityDataService.listCity());
        model.addAttribute("citys",getCitys(cityId.substring(3,5)));
        model.addAttribute("prefectures",getPrefectures(cityId.substring(3,5),cityId.substring(3,7)));
        model.addAttribute("report",weatherReportService.getDataByCityId(cityId));
        return "report";
    }




    @ResponseBody
    @GetMapping("/citys/{province}")
    public Province getCitys(@PathVariable String province) throws Exception {
        AtomicReference<Province> province1 = new AtomicReference<>();
        List<Province> provinces = cityDataService.listCity().getProvinces();
        provinces.forEach(e->{
            if (e.getId().equals(Integer.parseInt(province))){
                province1.set(e);
            }
        });
        return province1.get();
    }

    @ResponseBody
    @GetMapping("/citys/{province}/{city}")
    public City getPrefectures(@PathVariable String province,@PathVariable String city) throws Exception {
        AtomicReference<City> citys = new AtomicReference<>();
        List<Province> provinces = cityDataService.listCity().getProvinces();
        provinces.forEach(e->{
            if (e.getId().equals(Integer.parseInt(province))){
                e.getCityList().forEach(c->{
                    if (c.getCityId().equals(city)){
                        citys.set(c);
                    }
                });
            }
        });
        return citys.get();
    }

}
