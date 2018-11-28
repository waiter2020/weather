package com.upc.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by  waiter on 18-11-25  下午5:31.
 *
 * @author waiter
 */
@Data
@XmlRootElement(name = "China")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProvinceList implements Serializable {
    @XmlElement(name = "province")
    private List<Province> provinces;
}
