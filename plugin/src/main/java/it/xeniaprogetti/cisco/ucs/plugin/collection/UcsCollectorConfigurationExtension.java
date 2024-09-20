package it.xeniaprogetti.cisco.ucs.plugin.collection;

import org.opennms.integration.api.v1.config.collector.Collector;
import org.opennms.integration.api.v1.config.collector.CollectorConfigurationExtension;
import org.opennms.integration.api.xml.ClasspathCollectorConfigurationLoader;
import org.opennms.integration.api.v1.config.collector.Package;

import java.util.List;

public class UcsCollectorConfigurationExtension implements CollectorConfigurationExtension {

    private final CollectorConfigurationExtension collectorConfiguration = new ClasspathCollectorConfigurationLoader(
            UcsCollectorConfigurationExtension.class, "",
            "collector-configuration.xml"
    ).getCollectorConfiguration();

    @Override
    public List<Package> getPackages() {
        return this.collectorConfiguration.getPackages();
    }

    @Override
    public List<Collector> getCollectors() {
        return this.collectorConfiguration.getCollectors();
    }
}
