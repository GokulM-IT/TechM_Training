//package com.myTraining.core.models;
//
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.Default;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//
//@Model(adaptables = Resource.class)
//public class NewsModel {
//
//    @ValueMapValue
//    @Default(values = "Default News Title")
//    private String title;
//
//    @ValueMapValue
//    private String details;
//
//    @ValueMapValue
//    private String publishedDate;
//
//    @ValueMapValue
//    private String source;
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getDetails() {
//        return details;
//    }
//
//    public String getPublishedDate() {
//        return publishedDate;
//    }
//
//    public String getSource() {
//        return source;
//    }
//}
package com.myTraining.core.models;

import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.inject.Inject;

@Model(adaptables = org.apache.sling.api.resource.Resource.class)
public class NewsModel {

    @Inject
    @Default(values = "No Title")
    private String title;

    @Inject
    @Default(values = "No Details Available")
    private String detail;

    @Inject
    @Default(values = "Unknown Date")
    private String publishedDate;

    @Inject
    @Default(values = "Unknown Source")
    private String source;

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getSource() {
        return source;
    }
}
