package com.upc.job;

import com.upc.model.City;
import com.upc.model.Prefecture;
import com.upc.model.Province;
import com.upc.model.ProvinceList;
import com.upc.service.CityDataService;
import com.upc.service.WeatherService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by  waiter on 18-11-25  下午5:09.
 *
 * @author waiter
 */
public class WeatherDataSyncJob extends QuartzJobBean {
    private final static Logger LOG= LoggerFactory.getLogger(WeatherDataSyncJob.class);
    @Autowired
    private final CityDataService cityDataService;
    @Autowired
    private final WeatherService weatherService;

    public WeatherDataSyncJob(CityDataService cityDataService, WeatherService weatherService) {
        this.cityDataService = cityDataService;
        this.weatherService = weatherService;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.info("天气同步任务开始");
        ProvinceList provinceList=null;
        try {
            provinceList = cityDataService.listCity();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        for (Province province: provinceList.getProvinces()){
            for (City city:province.getCityList()){
                for (Prefecture prefecture:city.getPrefectures()){
                    weatherService.syncDataByCityId(prefecture.getCityCode());
                    weatherService.syncDataByCityName(prefecture.getCityName());
                }
            }
        }

        LOG.info("天气同步任务结束");
    }
}
