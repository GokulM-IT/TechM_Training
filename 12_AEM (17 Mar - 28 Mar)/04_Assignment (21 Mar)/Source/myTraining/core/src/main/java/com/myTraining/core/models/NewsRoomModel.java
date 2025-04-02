package com.myTraining.core.models; // Change to your actual package name

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NewsRoomModel {

    private static final Logger log = LoggerFactory.getLogger(NewsRoomModel.class);

    @Inject
    @Default(values = "/content/dam/myTraining/assets.jpg")
    private String defaultNewsImage;

    @Inject
    @Default(values = "Read More")
    private String readMoreCTA;

    @PostConstruct
    protected void init() {
        log.info("✅ NewsRoomModel initialized");
        log.info("📸 Default Image: {}", defaultNewsImage);
        log.info("🔗 Read More CTA: {}", readMoreCTA);
    }

    public String getDefaultNewsImage() {
        return defaultNewsImage;
    }

    public String getReadMoreCTA() {
        return readMoreCTA;
    }
}
