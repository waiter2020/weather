package com.upc.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by  waiter on 18-11-25  下午5:28.
 *
 * @author waiter
 */
@Data
@XmlRootElement(name = "county")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prefecture implements Serializable {
    @XmlAttribute(name = "id")
    private String cityId;
    @XmlAttribute(name = "name")
    private String cityName;
    @XmlAttribute(name = "weatherCode")
    private String cityCode;

}
