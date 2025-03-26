package com.newsBlog.core.services;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component(service = ApiService.class, immediate = true)
@Designate(ocd = ApiConfig.class)
public class ApiService {

    private static final Logger LOG = LoggerFactory.getLogger(ApiService.class);
    private String apiUrl;

    @Activate
    @Modified
    protected void activate(ApiConfig config) {
        this.apiUrl = config.apiEndpoint();
        LOG.info("API URL Configured: {}", apiUrl);
        fetchApiData();
    }

    public void fetchApiData() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(apiUrl);
            try (CloseableHttpResponse response = httpClient.execute(request);
                 InputStream contentStream = response.getEntity().getContent()) {

                String jsonResponse = IOUtils.toString(contentStream, StandardCharsets.UTF_8);
                LOG.info("API Response: {}", jsonResponse);
            }
        } catch (Exception e) {
            LOG.error("Error fetching API data", e);
        }
    }
}
