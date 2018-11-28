package com.upc.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by  waiter on 18-11-25  下午5:33.
 *
 * @author waiter
 */
public class XmlBuilder {
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws JAXBException, IOException {
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        reader.close();

        return xmlObject;
    }
}
