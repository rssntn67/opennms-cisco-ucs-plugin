package it.xeniaprogetti.cisco.ucs.plugin.graphs;

import org.opennms.integration.api.v1.config.datacollection.graphs.GraphPropertiesExtension;
import org.opennms.integration.api.v1.config.datacollection.graphs.PrefabGraph;
import org.opennms.integration.api.xml.ClassPathGraphPropertiesLoader;

import java.util.List;

public class CiscoUcsGraphPropertiesExtension implements GraphPropertiesExtension {

    private final ClassPathGraphPropertiesLoader graphPropertiesLoader = new ClassPathGraphPropertiesLoader(CiscoUcsGraphPropertiesExtension.class,
            "cisco-ucs-graph.properties");

    @Override
    public List<PrefabGraph> getPrefabGraphs() {
        return graphPropertiesLoader.getGraphProperties();
    }
}
