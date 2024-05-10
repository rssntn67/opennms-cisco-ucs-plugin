package it.xeniaprogetti.cisco.ucs.plugin.client.api;


import java.net.InetAddress;

public final class UcsManager extends UcsEntity {

    public final String label;
    public final InetAddress address;

    public static Builder builder() {
        return new Builder();
    }

    private UcsManager(Builder builder) {
        super(UcsDn.getDn(UcsUtils.UCS_MANAGER_DN), UcsEnums.ClassId.ucsManager, UcsEnums.ClassItem.otherItem);
        this.label = builder.label;
        this.address = builder.address;
    }

    public static class Builder {

        private String label;
        private InetAddress address;
        private Builder() {
        }

        public Builder witLabel(String label) {
            this.label = label;
            return this;
        }

        public Builder withAddress(InetAddress address) {
            this.address = address;
            return this;
        }

        public UcsManager build() {
            return new UcsManager(this);
        }

    }

}


