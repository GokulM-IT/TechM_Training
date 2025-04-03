package com.newsroomPortfolio.core.models;

import com.adobe.cq.wcm.core.components.models.ListItem;
import com.adobe.cq.wcm.core.components.util.AbstractComponentImpl;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NewsRoomModel extends AbstractComponentImpl {

    @Self
    private Resource resource;

    @ValueMapValue
    private String newsPath;

    private List<NewsItem> newsItems;

    @PostConstruct
    protected void init() {
        newsItems = new ArrayList<>();
        if (newsPath != null && !newsPath.isEmpty()) {
            ResourceResolver resolver = resource.getResourceResolver();
            Resource newsRoot = resolver.getResource(newsPath);

            if (newsRoot != null) {
                for (Resource newsResource : newsRoot.getChildren()) {
                    String title = newsResource.getValueMap().get("jcr:title", "Untitled News");
                    String image = newsResource.getValueMap().get("image", "");
                    String description = newsResource.getValueMap().get("text", "No description available.");

                    newsItems.add(new NewsItem(title, image, description, newsResource.getPath()));
                }
            }
        }
    }

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }

    public static class NewsItem {
        private final String title;
        private final String image;
        private final String description;
        private final String pagePath;

        public NewsItem(String title, String image, String description, String pagePath) {
            this.title = title;
            this.image = image;
            this.description = description;
            this.pagePath = pagePath;
        }

        public String getTitle() { return title; }
        public String getImage() { return image; }
        public String getDescription() { return description; }
        public String getPagePath() { return pagePath; }
    }
}
