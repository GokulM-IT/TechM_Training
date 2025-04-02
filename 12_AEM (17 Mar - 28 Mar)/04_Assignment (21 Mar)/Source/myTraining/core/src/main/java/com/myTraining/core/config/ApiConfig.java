package com.myTraining.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "API Configuration")
public @interface ApiConfig {

    @AttributeDefinition(name = "API Endpoint", description = "Enter the API URL")
    String apiEndpoint() default "https://jsonplaceholder.typicode.com/posts";
}
