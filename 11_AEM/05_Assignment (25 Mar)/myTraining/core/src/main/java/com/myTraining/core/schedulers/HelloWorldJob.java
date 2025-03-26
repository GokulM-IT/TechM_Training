package com.myTraining.core.schedulers;

import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = JobConsumer.class,
        property = {
                JobConsumer.PROPERTY_TOPICS + "=myTraining/job/helloWorld"
        }
)
public class HelloWorldJob implements JobConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldJob.class);

    @Override
    public JobResult process(Job job) {
        LOGGER.info("[Sling Job] Executing Hello World Job...");
        LOGGER.info("[Sling Job] Hello World!");
        return JobResult.OK;
    }
}
