package com.myTraining.core.models;

import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.inject.Inject;

@Model(adaptables = org.apache.sling.api.resource.Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BasePageModel {

    @Inject
    @Default(values = "Default Title")
    private String ogTitle;

    @Inject
    @Default(values = "Default Description")
    private String ogDescription;

    @Inject
    @Default(values = "/content/dam/default-image.jpg")
    private String ogImagePath;

    public String getOgTitle() {
        return ogTitle;
    }

    public String getOgDescription() {
        return ogDescription;
    }

    public String getOgImagePath() {
        return ogImagePath;
    }
}
