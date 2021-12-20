package org.hexlet.springlifecycledemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("example-bean")
public class ExampleComponent {
    @Autowired
    private ExampleAutowiredBean exampleAutowiredBean;
    private String exampleValue;

    public String getExampleValue() {
        return exampleValue;
    }

    public void setExampleValue(String exampleValue) {
        this.exampleValue = exampleValue;
    }

    public ExampleAutowiredBean getExampleAutowiredBean() {
        return exampleAutowiredBean;
    }

    public void setExampleAutowiredBean(ExampleAutowiredBean exampleAutowiredBean) {
        this.exampleAutowiredBean = exampleAutowiredBean;
    }

    @PostConstruct
    public void init() {
        System.out.println("[init] " + this.getClass().getName());
    }

    @PreDestroy
    public void destroy() {

    }
}
