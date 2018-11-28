package com.upc.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by  waiter on 18-11-25  下午1:04.
 *
 * @author waiter
 */
@Data
public class Yesterday implements Serializable {
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
