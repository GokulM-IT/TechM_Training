package com.servlet.core.servlets;

import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.search.PredicateGroup;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/searchContent",
                "sling.servlet.methods=GET"
        }
)
public class SearchServlet extends SlingSafeMethodsServlet {

    @Reference
    private QueryBuilder queryBuilder;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("query");

        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            response.getWriter().write("{\"error\": \"Search query is required.\"}");
            return;
        }

        ResourceResolver resolver = request.getResourceResolver();
        Session session = resolver.adaptTo(Session.class);

        if (session == null) {
            response.getWriter().write("{\"error\": \"Unable to get JCR session.\"}");
            return;
        }

        try {
            Map<String, String> predicateMap = new HashMap<>();
            predicateMap.put("type", "cq:Page");
            predicateMap.put("fulltext", searchTerm);
            predicateMap.put("path", "/content/servlet"); // Change as needed
            predicateMap.put("p.limit", "10"); // Limit results

            Query query = queryBuilder.createQuery(PredicateGroup.create(predicateMap), session);
            SearchResult searchResult = query.getResult();

            List<Hit> hits = searchResult.getHits();
            StringBuilder jsonResponse = new StringBuilder();
            jsonResponse.append("{ \"results\": [");

            for (int i = 0; i < hits.size(); i++) {
                String pagePath = hits.get(i).getPath();
                jsonResponse.append("{\"path\": \"").append(pagePath).append("\"}");
                if (i < hits.size() - 1) {
                    jsonResponse.append(",");
                }
            }
            jsonResponse.append("] }");

            response.setContentType("application/json");
            response.getWriter().write(jsonResponse.toString());

        } catch (Exception e) {
            response.getWriter().write("{\"error\": \"Error executing search: " + e.getMessage() + "\"}");
        }
    }
}
