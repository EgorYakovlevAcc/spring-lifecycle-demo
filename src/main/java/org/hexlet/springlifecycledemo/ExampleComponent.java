package org.hexlet.springlifecycledemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("example-bean")
public class ExampleComponent {
    @Autowired
    private ExampleAutowiredBean exampleAutowiredBean;
    @RandomValue(min = 50, max = 60)
    private Integer exampleValue;

    public ExampleAutowiredBean getExampleAutowiredBean() {
        return exampleAutowiredBean;
    }

    public void setExampleAutowiredBean(ExampleAutowiredBean exampleAutowiredBean) {
        this.exampleAutowiredBean = exampleAutowiredBean;
    }

    public Integer getExampleValue() {
        return exampleValue;
    }

    public void setExampleValue(Integer exampleValue) {
        this.exampleValue = exampleValue;
    }
}
