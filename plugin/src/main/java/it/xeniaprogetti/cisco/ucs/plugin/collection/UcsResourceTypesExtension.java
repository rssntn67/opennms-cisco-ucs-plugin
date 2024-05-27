package it.xeniaprogetti.cisco.ucs.plugin.collection;

import org.opennms.integration.api.v1.config.datacollection.ResourceType;
import org.opennms.integration.api.v1.config.datacollection.ResourceTypesExtension;
import org.opennms.integration.api.xml.ClassPathResourceTypesLoader;

import java.util.List;

public class UcsResourceTypesExtension implements ResourceTypesExtension {

    private final ClassPathResourceTypesLoader classPathResourceTypesLoader =
            new ClassPathResourceTypesLoader(UcsResourceTypesExtension.class, "cisco-ucs-resource.xml");

    @Override
    public List<ResourceType> getResourceTypes() {
        return classPathResourceTypesLoader.getResourceTypes();
    }}
