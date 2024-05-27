package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.List;

public class UcsComputeStats {
    public final List<UcsProcessorEnvStats> ucsProcessorEnvStats;

    private UcsComputeStats(Builder builder) {
        this.ucsProcessorEnvStats=builder.ucsProcessorEnvStats;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private List<UcsProcessorEnvStats> ucsProcessorEnvStats;

        private Builder() {

        }

        public Builder withUcsProcessorEnvStats(List<UcsProcessorEnvStats> ucsProcessorEnvStats) {
            this.ucsProcessorEnvStats=ucsProcessorEnvStats;
            return this;
        }

        public UcsComputeStats build() {
            return new UcsComputeStats(this);
        }
    }
}
