package com.myTraining.core.workflow;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = WorkflowProcess.class,
        property = {
                "process.label=Custom Workflow Process"
        }
)
public class CustomWorkflowProcess implements WorkflowProcess {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomWorkflowProcess.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) {
        LOGGER.info("[Custom Workflow] Executing workflow process...");

        if (workItem == null || workItem.getWorkflowData() == null) {
            LOGGER.error("[Custom Workflow] WorkItem or WorkflowData is NULL!");
            return;
        }

        String payloadPath = workItem.getWorkflowData().getPayload().toString();
        LOGGER.info("[Custom Workflow] Payload Path: {}", payloadPath);

        // Get the Resource Resolver
        ResourceResolver resolver = workflowSession.adaptTo(ResourceResolver.class);
        if (resolver != null) {
            Resource resource = resolver.getResource(payloadPath);
            if (resource != null) {
                PageManager pageManager = resolver.adaptTo(PageManager.class);
                Page page = pageManager.getContainingPage(resource);
                if (page != null) {
                    LOGGER.info("[Custom Workflow] Page Title: {}", page.getTitle());
                    LOGGER.info("[Custom Workflow] Page Path: {}", page.getPath());
                } else {
                    LOGGER.warn("[Custom Workflow] No Page found for the given resource.");
                }
            } else {
                LOGGER.warn("[Custom Workflow] No Resource found at the given path.");
            }
        } else {
            LOGGER.error("[Custom Workflow] Resource Resolver is NULL.");
        }
    }
}
