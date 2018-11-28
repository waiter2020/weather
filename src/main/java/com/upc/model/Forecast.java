package com.upc.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by  waiter on 18-11-25  下午1:06.
 *
 * @author waiter
 */
@Data
public class Forecast implements Serializable {
    private String date;
    private String high;
    private String fengxiang;
    private String low;
    private String fengli;
    private String type;
}
