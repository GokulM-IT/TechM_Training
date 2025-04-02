
package com.myTraining.core.models;

import com.adobe.cq.sightly.WCMUsePojo;
import com.myTraining.core.services.HelloWorldService;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.Resource;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class NewsComponentModel {

    private static final Logger LOG = LoggerFactory.getLogger(NewsComponentModel.class);

    @OSGiService
    private HelloWorldService helloWorldService;

    public String getHelloMessage() {
        String message = helloWorldService.getMessage();
        LOG.info("News Component says: {}", message);
        return message;
    }
}
