package it.xeniaprogetti.cisco.ucs.plugin.events;

import java.util.List;

import org.opennms.integration.api.v1.config.events.EventDefinition;
import org.opennms.integration.api.xml.ClasspathEventDefinitionLoader;

public class EventConfExtension implements org.opennms.integration.api.v1.config.events.EventConfExtension {

    private final ClasspathEventDefinitionLoader classpathEventDefinitionLoader = new ClasspathEventDefinitionLoader(
            EventConfExtension.class,
            "cisco-ucs.plugin.ext.events.xml"
    );

    @Override
    public List<EventDefinition> getEventDefinitions() {
        return classpathEventDefinitionLoader.getEventDefinitions();
    }
}
