package com.servlet.core.servlets;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

@Component(service = javax.servlet.Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "servlet/components/page", // Must match sling:resourceType in JCR
        methods = { "GET" },
        extensions = "json"
)
public class SampleServlet extends SlingAllMethodsServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write("{ \"message\": \"Hello from SampleServlet!\" }");
    }
}
