package com.servlet.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_PATHS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_METHODS;

@Component(
        service = Servlet.class,
        property = {
                SLING_SERVLET_PATHS + "=/bin/createPage",
                SLING_SERVLET_METHODS + "=GET"
        }
)
public class CreatePageServlet extends SlingSafeMethodsServlet {

    private static final String PARENT_PATH = "/content/servlet"; // Set your parent path
    private static final String TEMPLATE_PATH = "/conf/servlet/settings/wcm/templates/page-content"; // Set your template path

    @Reference
    private org.apache.sling.api.resource.ResourceResolverFactory resourceResolverFactory;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String pageName = request.getParameter("pageName");

        if (pageName == null || pageName.isEmpty()) {
            response.getWriter().write("Page name is required!");
            return;
        }

        org.apache.sling.api.resource.ResourceResolver resolver = request.getResourceResolver();
        PageManager pageManager = resolver.adaptTo(PageManager.class);

        if (pageManager != null) {
            try {
                Page newPage = pageManager.create(PARENT_PATH, pageName, TEMPLATE_PATH, pageName);
                response.getWriter().write("Page created successfully at: " + newPage.getPath());
            } catch (WCMException e) {
                response.getWriter().write("Error creating page: " + e.getMessage());
            }
        } else {
            response.getWriter().write("PageManager is null. Unable to create page.");
        }
    }
}
