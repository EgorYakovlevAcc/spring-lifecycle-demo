package org.hexlet.springlifecycledemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class ExampleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[postProcessBeforeInitialization] " + beanName);
        if (beanName.equals("example-bean")) {
            ExampleComponent exampleComponent = (ExampleComponent) bean;
            System.out.println(exampleComponent.getExampleAutowiredBean());
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[postProcessAfterInitialization] " + beanName);
        if (beanName.equals("example-bean")) {
            ExampleComponent exampleComponent = (ExampleComponent) bean;
            System.out.println(exampleComponent.getExampleAutowiredBean());
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
