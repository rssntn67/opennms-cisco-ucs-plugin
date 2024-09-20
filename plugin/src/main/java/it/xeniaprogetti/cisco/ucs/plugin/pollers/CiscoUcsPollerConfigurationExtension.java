package it.xeniaprogetti.cisco.ucs.plugin.pollers;

import org.opennms.integration.api.v1.config.poller.Monitor;
import org.opennms.integration.api.v1.config.poller.Package;
import org.opennms.integration.api.v1.config.poller.PollerConfigurationExtension;
import org.opennms.integration.api.xml.ClasspathPollerConfigurationLoader;

import java.util.List;

public class CiscoUcsPollerConfigurationExtension implements PollerConfigurationExtension {
        final PollerConfigurationExtension pollerConfiguration = new ClasspathPollerConfigurationLoader(CiscoUcsPollerConfigurationExtension.class, "",
                "poller-configuration.xml").getPollerConfiguration();

        @Override
        public List<Package> getPackages() {
            return pollerConfiguration.getPackages();
        }

        @Override
        public List<Monitor> getMonitors() {
            return pollerConfiguration.getMonitors();
        }
}
