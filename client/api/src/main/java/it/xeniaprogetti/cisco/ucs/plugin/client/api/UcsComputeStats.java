package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.List;

public class UcsComputeStats {
    public final List<UcsProcessorEnvStats> ucsProcessorEnvStats;
    public final UcsComputeMbPowerStats ucsComputeMbPowerStats;
    public final UcsComputeMbTempStats ucsComputeMbTempStats;


    private UcsComputeStats(Builder builder) {
        this.ucsProcessorEnvStats = builder.ucsProcessorEnvStats;
        this.ucsComputeMbTempStats = builder.ucsComputeMbTempStats;
        this.ucsComputeMbPowerStats = builder.ucsComputeMbPowerStats;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private List<UcsProcessorEnvStats> ucsProcessorEnvStats;
        private UcsComputeMbPowerStats ucsComputeMbPowerStats;
        private UcsComputeMbTempStats ucsComputeMbTempStats;

        private Builder() {

        }

        public Builder withUcsProcessorEnvStats(List<UcsProcessorEnvStats> ucsProcessorEnvStats) {
            this.ucsProcessorEnvStats=ucsProcessorEnvStats;
            return this;
        }

        public Builder withUcsComputeMbPowerStats(UcsComputeMbPowerStats ucsComputeMbPowerStats) {
            this.ucsComputeMbPowerStats = ucsComputeMbPowerStats;
            return this;
        }

        public Builder withUcsComputeTempStats(UcsComputeMbTempStats ucsComputeMbTempStats) {
            this.ucsComputeMbTempStats = ucsComputeMbTempStats;
            return this;
        }
        public UcsComputeStats build() {
            return new UcsComputeStats(this);
        }
    }
}
