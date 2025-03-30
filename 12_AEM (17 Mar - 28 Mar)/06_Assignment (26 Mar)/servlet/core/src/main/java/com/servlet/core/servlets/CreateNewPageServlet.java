package com.servlet.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/createNewPage",
                "sling.servlet.methods=GET"
        }
)
public class CreateNewPageServlet extends SlingSafeMethodsServlet {

    private static final String PARENT_PATH = "/content/servlet"; // Change as needed
    private static final String TEMPLATE_PATH = "/conf/servlet/settings/wcm/templates/page-content"; // Change as needed

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String pageName = request.getParameter("pageName");

        if (pageName == null || pageName.trim().isEmpty()) {
            response.getWriter().write("Error: Page name is required.");
            return;
        }

        String formattedPageName = "custom-" + pageName; // Append "custom-" prefix to page name

        ResourceResolver resolver = request.getResourceResolver();
        PageManager pageManager = resolver.adaptTo(PageManager.class);

        if (pageManager != null) {
            try {
                Page newPage = pageManager.create(PARENT_PATH, formattedPageName, TEMPLATE_PATH, formattedPageName);
                response.getWriter().write("Page created successfully at: " + newPage.getPath());
            } catch (WCMException e) {
                response.getWriter().write("Error creating page: " + e.getMessage());
            }
        } else {
            response.getWriter().write("Error: PageManager is null. Unable to create page.");
        }
    }
}
