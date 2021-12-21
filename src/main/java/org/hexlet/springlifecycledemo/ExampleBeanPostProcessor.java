package org.hexlet.springlifecycledemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

@Component
public class ExampleBeanPostProcessor implements BeanPostProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleBeanPostProcessor.class);
    private static final Random RANDOM = new Random();

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
        for (Field field: bean.getClass().getDeclaredFields()) {
            RandomValue randomValue = field.getAnnotation(RandomValue.class);
            if (randomValue != null) {
                int min = randomValue.min();
                int max = randomValue.max();
                fillField(field, bean, getRandomValue(min, max));
            }
        }
        return bean;
    }

    private void fillField(Field field, Object bean, int value) {
        field.setAccessible(true);
        try {
            field.set(bean, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private Integer getRandomValue(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }
}
