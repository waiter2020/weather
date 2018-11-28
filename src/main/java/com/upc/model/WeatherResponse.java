package com.upc.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by  waiter on 18-11-25  下午1:09.
 *
 * @author waiter
 */
@Data
public class WeatherResponse implements Serializable {
    private Weather data;
    private String status;
    private String desc;
}
