package it.xeniaprogetti.cisco.ucs.plugin.client.api;

public class UcsIpPoolPooled {
    public final String poolDn;
    public final String assignedToProfileDn;
    public final String assignedToDeviceDn;
    public final String addr;
    public final String defGw;
    public final String subnet;

    public static UcsIpPoolPooled.Builder builder() {
        return new Builder();
    }

    public UcsIpPoolPooled(Builder builder) {
        this.addr = builder.addr;
        this.defGw = builder.defGw;
        this.subnet = builder.subnet;
        this.assignedToProfileDn = builder.assignedToProfileDn;
        this.assignedToDeviceDn = builder.assignedToDeviceDn;
        this.poolDn = builder.poolDn;
    }


    public static class Builder {
        private String poolDn;
        private String assignedToProfileDn;
        private String assignedToDeviceDn;
        private String addr;
        private String defGw;
        private String subnet;

        private Builder() {
        }

        public UcsIpPoolPooled build() {
            return new UcsIpPoolPooled(this);
        }

        public Builder withPoolDn(String poolDn) {
            this.poolDn = poolDn;
            return this;
        }

        public Builder withAssignedProfileToDn(String assignedToProfileDn) {
            this.assignedToProfileDn = assignedToProfileDn;
            return this;
        }

        public Builder withAssignedDeviceToDn(String assignedToDeviceDn) {
            this.assignedToDeviceDn = assignedToDeviceDn;
            return this;
        }

        public Builder withAddr(String addr) {
            this.addr = addr;
            return this;
        }

        public Builder withDefGw(String defGw) {
            this.defGw = defGw;
            return this;
        }

        public Builder withSubnet(String subnet) {
            this.subnet = subnet;
            return this;
        }



    }


}
