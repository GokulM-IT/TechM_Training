package com.myTraining.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Runnable.class, immediate = true)
@Designate(ocd = YellowWorldScheduler.Config.class)
public class YellowWorldScheduler implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(YellowWorldScheduler.class);

    @Reference
    private Scheduler scheduler;

    private String cronExpression;

    @ObjectClassDefinition(name = "Yellow World Scheduler Configuration")
    public @interface Config {
        @AttributeDefinition(
                name = "Cron Expression",
                description = "Schedule the job to run every 5 minutes",
                type = AttributeType.STRING
        )
        String cron_expression() default "0 */5 * * * ?";
    }

    @Activate
    @Modified
    protected void activate(Config config) {
        cronExpression = config.cron_expression();
        scheduleJob();
    }

    private void scheduleJob() {
        ScheduleOptions scheduleOptions = scheduler.EXPR(cronExpression);
        scheduleOptions.name("YellowWorldSchedulerJob");
        scheduleOptions.canRunConcurrently(false);
        scheduler.schedule(this, scheduleOptions);
        LOGGER.info("Yellow World Scheduler Registered with Cron: {}", cronExpression);
    }

    @Override
    public void run() {
        LOGGER.info("[Scheduler] Yellow World!");
    }
}
