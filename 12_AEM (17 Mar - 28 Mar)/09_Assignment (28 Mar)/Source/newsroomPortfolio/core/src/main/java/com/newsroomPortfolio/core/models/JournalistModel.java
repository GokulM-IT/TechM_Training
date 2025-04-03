package com.newsroomPortfolio.core.models;

import org.apache.sling.api.resource.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Exporter;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION,
        selector = "journalist") // Added selector
public class JournalistModel {

    @Inject @Named("name")
    @Default(values = "Unknown Journalist")
    private String name;

    @Inject @Named("image")
    @Default(values = "/content/dam/newsroomPortfolio/us/en-us/professional.png")
    private String image;

    @Inject @Named("bio")
    @Default(values = "No bio available.")
    private String bio;

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getBio() {
        return bio;
    }
}
