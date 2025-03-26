package com.newsBlog.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "API Configuration", description = "Configuration for third-party API")
public @interface ApiConfig {

    @AttributeDefinition(name = "API Endpoint", description = "Provide the API URL to fetch JSON data")
    String apiEndpoint() default "https://jsonplaceholder.typicode.com/posts";
}
