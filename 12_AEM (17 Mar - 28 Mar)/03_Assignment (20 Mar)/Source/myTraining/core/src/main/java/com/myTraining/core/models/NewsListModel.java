package com.myTraining.core.models;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.Resource;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NewsListModel {

    @Inject
    private List<NewsItem> newsItems;

    public List<NewsItem> getNewsItems() {
        return Optional.ofNullable(newsItems).orElse(new ArrayList<>());
    }

    public static class NewsItem {
        @Inject
        private String title;

        @Inject
        private String source;

        public String getTitle() {
            return title;
        }

        public String getSource() {
            return source;
        }
    }
}
