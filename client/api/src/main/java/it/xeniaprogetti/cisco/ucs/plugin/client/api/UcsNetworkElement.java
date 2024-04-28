package it.xeniaprogetti.cisco.ucs.plugin.client.api;


public final class UcsNetworkElement extends UcsEntity {
    
    public final String adminEvacState;
    
    public final String adminInbandIfState;
    
    public final int diffMemory;
    
    public final int expectedMemory;
    
    public final double fltAggr;
    
    public final String forceEvac;
    
    public final String id;
    
    public final String inbandIfGw;
    
    public final String inbandIfIp;
    
    public final String inbandIfMask;
    
    public final int inbandIfVnet;
    
    public final String inventoryStatus;
    
    public final int minActiveFan;
    
    public final String model;
    
    public final String oobIfGw;
    
    public final String oobIfIp;
    
    public final String oobIfMac;
    
    public final String oobIfMask;
    
    public final String operEvacState;
    
    public final String operability;
    
    public final int revision;
    
    public final String serial;
    
    public final String shutdownFanRemoveal;
    
    public final String thermal;
    
    public final int totalMemory;
    
    public final String vendor;

    public static UcsNetworkElement.Builder builder() {
        return new UcsNetworkElement.Builder();
    }

    public UcsNetworkElement(UcsNetworkElement.Builder builder) {
        super(builder.dn, ClassId.networkElement, ClassItem.otherItem);
        this.adminEvacState = builder.adminEvacState;
        this.adminInbandIfState = builder.adminInbandIfState;
        this.diffMemory = builder.diffMemory;
        this.expectedMemory = builder.expectedMemory;
        this.fltAggr = builder.fltAggr;
        this.forceEvac = builder.forceEvac;
        this.id = builder.id;
        this.inbandIfGw = builder.inbandIfGw;
        this.inbandIfIp = builder.inbandIfIp;
        this.inbandIfMask = builder.inbandIfMask;
        this.inbandIfVnet = builder.inbandIfVnet;
        this.inventoryStatus = builder.inventoryStatus;
        this.minActiveFan = builder.minActiveFan;
        this.model = builder.model;
        this.oobIfGw = builder.oobIfGw;
        this.oobIfIp = builder.oobIfIp;
        this.oobIfMac = builder.oobIfMac;
        this.oobIfMask = builder.oobIfMask;
        this.operEvacState = builder.operEvacState;
        this.operability = builder.operability;
        this.revision = builder.revision;
        this.serial = builder.serial;
        this.shutdownFanRemoveal = builder.shutdownFanRemoveal;
        this.thermal = builder.thermal;
        this.totalMemory = builder.totalMemory;
        this.vendor = builder.vendor;
    }

    @Override
    public String toString() {
        return "NetworkElement{" +
                "adminEvacState='" + adminEvacState + '\'' +
                ", adminInbandIfState='" + adminInbandIfState + '\'' +
                ", diffMemory=" + diffMemory +
                ", dn='" + dn + '\'' +
                ", expectedMemory=" + expectedMemory +
                ", fltAggr=" + fltAggr +
                ", forceEvac='" + forceEvac + '\'' +
                ", id='" + id + '\'' +
                ", inbandIfGw='" + inbandIfGw + '\'' +
                ", inbandIfIp='" + inbandIfIp + '\'' +
                ", inbandIfMask='" + inbandIfMask + '\'' +
                ", inbandIfVnet=" + inbandIfVnet +
                ", inventoryStatus='" + inventoryStatus + '\'' +
                ", minActiveFan=" + minActiveFan +
                ", model='" + model + '\'' +
                ", oobIfGw='" + oobIfGw + '\'' +
                ", oobIfIp='" + oobIfIp + '\'' +
                ", oobIfMac='" + oobIfMac + '\'' +
                ", oobIfMask='" + oobIfMask + '\'' +
                ", operEvacState='" + operEvacState + '\'' +
                ", operability='" + operability + '\'' +
                ", revision=" + revision +
                ", serial='" + serial + '\'' +
                ", shutdownFanRemoveal='" + shutdownFanRemoveal + '\'' +
                ", thermal='" + thermal + '\'' +
                ", totalMemory=" + totalMemory +
                ", vendor='" + vendor + '\'' +
                '}';
    }

    public static class Builder {
        private String dn;
        private String adminEvacState;
        private String adminInbandIfState;
        private int diffMemory;
        private int expectedMemory;
        private double fltAggr;
        private String forceEvac;
        private String id;
        private String inbandIfGw;
        private String inbandIfIp;
        private String inbandIfMask;
        private int inbandIfVnet;
        private String inventoryStatus;
        private int minActiveFan;
        private String model;
        private String oobIfGw;
        private String oobIfIp;
        private String oobIfMac;
        private String oobIfMask;
        private String operEvacState;
        private String operability;
        private int revision;
        private String serial;
        private String shutdownFanRemoveal;
        private String thermal;
        private int totalMemory;
        private String vendor;

        private Builder() {

        }

        public Builder withDn(String dn) {
            this.dn = dn;
            return this;
        }

        public Builder withAdminEvacState(String adminEvacState) {
            this.adminEvacState = adminEvacState;
            return this;
        }

        public Builder withAdminInbandIfState(String adminInbandIfState) {
            this.adminInbandIfState = adminInbandIfState;
            return this;
        }

        public Builder withDiffMemory(int diffMemory) {
            this.diffMemory = diffMemory;
            return this;
        }

        public Builder withExpectedMemory(int expectedMemory) {
            this.expectedMemory = expectedMemory;
            return this;
        }

        public Builder withFltAggr(double fltAggr) {
            this.fltAggr = fltAggr;
            return this;
        }

        public Builder withForceEvac(String forceEvac) {
            this.forceEvac = forceEvac;
            return this;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withInbandIfGw(String inbandIfGw) {
            this.inbandIfGw = inbandIfGw;
            return this;
        }

        public Builder withInbandIfIp(String inbandIfIp) {
            this.inbandIfIp = inbandIfIp;
            return this;
        }

        public Builder withInbandIfMask(String inbandIfMask) {
            this.inbandIfMask = inbandIfMask;
            return this;
        }

        public Builder withInbandIfVnet(int inbandIfVnet) {
            this.inbandIfVnet = inbandIfVnet;
            return this;
        }

        public Builder withInventoryStatus(String inventoryStatus) {
            this.inventoryStatus = inventoryStatus;
            return this;
        }

        public Builder withMinActiveFan(int minActiveFan) {
            this.minActiveFan = minActiveFan;
            return this;
        }

        public Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public Builder withOobIfGw(String oobIfGw) {
            this.oobIfGw = oobIfGw;
            return this;
        }

        public Builder withOobIfIp(String oobIfIp) {
            this.oobIfIp = oobIfIp;
            return this;
        }

        public Builder withOobIfMac(String oobIfMac) {
            this.oobIfMac = oobIfMac;
            return this;
        }

        public Builder withOobIfMask(String oobIfMask) {
            this.oobIfMask = oobIfMask;
            return this;
        }

        public Builder withOperEvacState(String operEvacState) {
            this.operEvacState = operEvacState;
            return this;
        }

        public Builder withOperability(String operability) {
            this.operability = operability;
            return this;
        }

        public Builder withRevision(int revision) {
            this.revision = revision;
            return this;
        }

        public Builder withSerial(String serial) {
            this.serial = serial;
            return this;
        }

        public Builder withShutdownFanRemoveal(String shutdownFanRemoveal) {
            this.shutdownFanRemoveal = shutdownFanRemoveal;
            return this;
        }

        public Builder withThermal(String thermal) {
            this.thermal = thermal;
            return this;
        }

        public Builder withTotalMemory(int totalMemory) {
            this.totalMemory = totalMemory;
            return this;
        }

        public Builder withVendor(String vendor) {
            this.vendor = vendor;
            return this;
        }

        public UcsNetworkElement build() {
            return new UcsNetworkElement(this);
        }

    }
}

