//package com.myTraining.core.workflows;
//
//import com.adobe.granite.workflow.WorkflowException;
//import com.adobe.granite.workflow.WorkflowSession;
//import com.adobe.granite.workflow.exec.WorkItem;
//import com.adobe.granite.workflow.exec.WorkflowProcess;
//import com.adobe.granite.workflow.metadata.MetaDataMap;
//import com.day.cq.wcm.api.Page;
//import com.day.cq.wcm.api.PageManager;
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.api.resource.ResourceResolver;
//import org.osgi.service.component.annotations.Component;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Component(
//        service = WorkflowProcess.class,
//        property = {"process.label=My Custom Workflow"}
//)
//public class MyCustomWorkflowProcess implements WorkflowProcess {
//
//    private static final Logger log = LoggerFactory.getLogger(MyCustomWorkflowProcess.class);
//
//    @Override
//    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
//        log.info("[My Custom Workflow] Execution Started...");
//
//        // Validate work item and workflow data
//        if (workItem == null || workItem.getWorkflowData() == null) {
//            log.error("[My Custom Workflow] WorkItem or WorkflowData is NULL!");
//            return;
//        }
//
//        // Extract payload path (page path)
//        String payloadPath = workItem.getWorkflowData().getPayload().toString();
//        log.info("[My Custom Workflow] Payload Path: {}", payloadPath);
//
//        // Get the Resource Resolver
//        ResourceResolver resolver = workflowSession.adaptTo(ResourceResolver.class);
//        if (resolver == null) {
//            log.error("[My Custom Workflow] Resource Resolver is NULL.");
//            return;
//        }
//
//        // Get the Page Resource
//        Resource resource = resolver.getResource(payloadPath);
//        if (resource == null) {
//            log.warn("[My Custom Workflow] No Resource found at the given path.");
//            return;
//        }
//
//        // Get Page Manager and Page
//        PageManager pageManager = resolver.adaptTo(PageManager.class);
//        if (pageManager == null) {
//            log.error("[My Custom Workflow] PageManager is NULL.");
//            return;
//        }
//
//        Page page = pageManager.getContainingPage(resource);
//        if (page != null) {
//            log.info("[My Custom Workflow] Page Title: {}", page.getTitle());
//            log.info("[My Custom Workflow] Page Path: {}", page.getPath());
//        } else {
//            log.warn("[My Custom Workflow] No Page found for the given resource.");
//        }
//    }
//}
package com.myTraining.core.workflows;

import com.adobe.granite.workflow.WorkflowException;
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
        property = {"process.label=My Custom Workflow"}
)
public class MyCustomWorkflowProcess implements WorkflowProcess {

    private static final Logger log = LoggerFactory.getLogger(MyCustomWorkflowProcess.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        log.info("[My Custom Workflow] Execution Started...");

        if (workItem == null || workItem.getWorkflowData() == null) {
            log.error("[My Custom Workflow] WorkItem or WorkflowData is NULL!");
            return;
        }

        String payloadPath = workItem.getWorkflowData().getPayload().toString();
        log.info("[My Custom Workflow] Payload Path: {}", payloadPath);

        ResourceResolver resolver = workflowSession.adaptTo(ResourceResolver.class);
        if (resolver == null) {
            log.error("[My Custom Workflow] Resource Resolver is NULL.");
            return;
        }

        Resource resource = resolver.getResource(payloadPath);
        if (resource == null) {
            log.warn("[My Custom Workflow] No Resource found at the given path.");
            return;
        }

        PageManager pageManager = resolver.adaptTo(PageManager.class);
        if (pageManager == null) {
            log.error("[My Custom Workflow] PageManager is NULL.");
            return;
        }

        Page page = pageManager.getContainingPage(resource);
        if (page != null) {
            log.info("[My Custom Workflow] Page Title: {}", page.getTitle());
            log.info("[My Custom Workflow] Page Path: {}", page.getPath());
        } else {
            log.warn("[My Custom Workflow] No Page found for the given resource.");
        }
    }
}
