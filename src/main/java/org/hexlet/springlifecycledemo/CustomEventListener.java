package org.hexlet.springlifecycledemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomEventListener.class);
    @Autowired
    private ExampleComponent exampleComponent;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.info("RANDOM VALUE: {}", exampleComponent.getExampleValue());
    }
}
