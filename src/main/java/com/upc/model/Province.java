package com.upc.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by  waiter on 18-11-25  下午6:08.
 *
 * @author waiter
 */
@Data
@XmlRootElement(name = "province")
public class Province implements Serializable {

    private Integer id;

    private String name;
    private List<City> cityList;

    @XmlElement(name = "city")
    public List<City> getCityList() {
        return cityList;
    }


    @XmlAttribute(name = "id")
    public Integer getId() {
        return id;
    }
    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }


}
