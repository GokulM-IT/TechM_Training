package com.newsBlog.core.services.impl;

import com.newsBlog.core.services.HelloWorldService;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = HelloWorldService.class)
public class HelloWorldServiceImpl implements HelloWorldService {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldServiceImpl.class);

    @Override
    public void logHelloMessage() {
        LOG.info("Hello World from OSGi Service!");
    }
}
