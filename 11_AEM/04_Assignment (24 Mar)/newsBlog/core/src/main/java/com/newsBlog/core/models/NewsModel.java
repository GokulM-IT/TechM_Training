package com.newsBlog.core.models;

import com.newsBlog.core.services.HelloWorldService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NewsModel {

    private static final Logger LOG = LoggerFactory.getLogger(NewsModel.class);

    @OSGiService
    private HelloWorldService helloWorldService;

    @PostConstruct
    protected void init() {
        LOG.info("NewsModel @PostConstruct executed!");

        if (helloWorldService != null) {
            helloWorldService.logHelloMessage();
        } else {
            LOG.error("HelloWorldService is null!");
        }
    }
}
