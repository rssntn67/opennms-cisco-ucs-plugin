package it.xeniaprogetti.cisco.ucs.plugin.client.api;

public class UcsIpPoolPooled {
    public final UcsDn poolDn;
    public final UcsDn assignedToProfileDn;
    public final UcsDn assignedToDeviceDn;
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

    @Override
    public String toString() {
        return "UcsIpPoolPooled{" +
                "poolDn=" + poolDn +
                ", assignedToProfileDn=" + assignedToProfileDn +
                ", assignedToDeviceDn=" + assignedToDeviceDn +
                ", addr='" + addr + '\'' +
                ", defGw='" + defGw + '\'' +
                ", subnet='" + subnet + '\'' +
                '}';
    }

    public static class Builder {
        private UcsDn poolDn;
        private UcsDn assignedToProfileDn;
        private UcsDn assignedToDeviceDn;
        private String addr;
        private String defGw;
        private String subnet;

        private Builder() {
        }

        public UcsIpPoolPooled build() {
            return new UcsIpPoolPooled(this);
        }

        public Builder withPoolDn(String poolDn) {
            this.poolDn = UcsDn.getDn(poolDn);
            return this;
        }

        public Builder withAssignedProfileToDn(String assignedToProfileDn) {
            this.assignedToProfileDn = UcsDn.getDn(assignedToProfileDn);
            return this;
        }

        public Builder withAssignedDeviceToDn(String assignedToDeviceDn) {
            this.assignedToDeviceDn = UcsDn.getDn(assignedToDeviceDn);
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
