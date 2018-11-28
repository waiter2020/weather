package com.upc.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by  waiter on 18-11-25  下午6:25.
 *
 * @author waiter
 */
@Data
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City implements Serializable {
    @XmlAttribute(name = "id")
    private String cityId;
    @XmlAttribute(name = "name")
    private String cityName;
    @XmlElement(name = "county")
    private List<Prefecture> prefectures;
}
