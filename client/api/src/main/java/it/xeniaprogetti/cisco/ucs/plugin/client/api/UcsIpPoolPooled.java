package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.net.InetAddress;

public class UcsIpPoolPooled {
    public final String poolDn;
    public final String assignedToProfileDn;
    public final String assignedToDeviceDn;
    public final InetAddress addr;
    public final InetAddress defGw;
    public final InetAddress subnet;

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
        private InetAddress addr;
        private InetAddress defGw;
        private InetAddress subnet;

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

        public Builder withAddr(InetAddress addr) {
            this.addr = addr;
            return this;
        }

        public Builder withDefGw(InetAddress defGw) {
            this.defGw = defGw;
            return this;
        }

        public Builder withSubnet(InetAddress subnet) {
            this.subnet = subnet;
            return this;
        }



    }


}
