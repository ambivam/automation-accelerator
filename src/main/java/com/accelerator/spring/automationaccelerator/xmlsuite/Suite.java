package com.accelerator.spring.automationaccelerator.xmlsuite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;

@XmlRootElement(name = "suite")
public class Suite {
    private String name;
    private String parallel;
    private String test;

    public String getName() {
        return name;
    }

    public String getParallel() {
        return parallel;
    }

    @XmlAttribute(name="test")
    public String getTest() {
        return test;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public void setParallel(String parallel) {
        this.parallel = parallel;
    }

    @XmlElement(name = "test")
    public void setTest(String test) {
        this.test = test;
    }

    public static void main(String[] args) throws JAXBException, IOException {
        Suite suite = new Suite();
        suite.setName("predictionssuite");
        suite.setParallel("classes");
        suite.setTest("test");

        JAXBContext context = JAXBContext.newInstance(Suite.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(suite, new File("./predictionssuite.xml"));

    }

}
