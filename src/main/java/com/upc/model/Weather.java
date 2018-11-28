package com.upc.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by  waiter on 18-11-25  下午12:48.
 *
 * @author waiter
 */
@Data
public class Weather implements Serializable {
    private String city;
    private String aqi;
    private String wendu;
    private String ganmao;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
