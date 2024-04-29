package it.xeniaprogetti.cisco.ucs.plugin.client.api;


public final class UcsEquipmentRackEnclosure extends UcsEntity {
    
    public final String assetTag;
    
    public final int fltAggr;
    
    public final int id;
    
    public final String mfgTime;
    
    public final String model;
    
    public final String operQualifierReason;
    
    public final String operability;
    
    public final String partNumber;
    
    public final String presence;
    
    public final int revision;
    
    public final String serial;
    
    public final String vendor;
    
    public final int vid;


    public UcsEquipmentRackEnclosure(UcsEquipmentRackEnclosure.Builder builder) {
        super(builder.dn, ClassId.equipmentRackEnclosure, ClassItem.equipmentItem);
        this.assetTag = builder.assetTag;
        this.fltAggr = builder.fltAggr;
        this.id = builder.id;
        this.mfgTime = builder.mfgTime;
        this.model = builder.model;
        this.operQualifierReason = builder.operQualifierReason;
        this.operability = builder.operability;
        this.partNumber = builder.partNumber;
        this.presence = builder.presence;
        this.revision = builder.revision;
        this.serial = builder.serial;
        this.vendor = builder.vendor;
        this.vid = builder.vid;
    }

    public static UcsEquipmentRackEnclosure.Builder builder() {
        return new UcsEquipmentRackEnclosure.Builder();
    }

    @Override
    public String toString() {
        return "EquipmentRackEnclosure{" +
                "dn='" + dn + '\'' +
                ", classId=" + classId +
                ", classItem=" + classItem +
                ", assetTag='" + assetTag + '\'' +
                ", fltAggr=" + fltAggr +
                ", id=" + id +
                ", mfgTime='" + mfgTime + '\'' +
                ", model='" + model + '\'' +
                ", operQualifierReason='" + operQualifierReason + '\'' +
                ", operability='" + operability + '\'' +
                ", partNumber=" + partNumber +
                ", presence='" + presence + '\'' +
                ", revision=" + revision +
                ", serial='" + serial + '\'' +
                ", vendor='" + vendor + '\'' +
                ", vid=" + vid +
                '}';
    }

    public static class Builder {
        private String dn;
        private String assetTag;
        private int fltAggr;
        private int id;
        private String mfgTime;
        private String model;
        private String operQualifierReason;
        private String operability;
        private String partNumber;
        private String presence;
        private int revision;
        private String serial;
        private String vendor;
        private int vid;

        private Builder() {

        }
        public Builder withDn(String dn) {
            this.dn = dn;
            return this;
        }

        public Builder withAssetTag(String assetTag) {
            this.assetTag = assetTag;
            return this;
        }

        public Builder withFltAggr(int fltAggr) {
            this.fltAggr = fltAggr;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withMfgTime(String mfgTime) {
            this.mfgTime = mfgTime;
            return this;
        }

        public Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public Builder withOperQualifierReason(String operQualifierReason) {
            this.operQualifierReason = operQualifierReason;
            return this;
        }

        public Builder withOperability(String operability) {
            this.operability = operability;
            return this;
        }

        public Builder withPartNumber(String partNumber) {
            this.partNumber = partNumber;
            return this;
        }

        public Builder withPresence(String presence) {
            this.presence = presence;
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

        public Builder withVendor(String vendor) {
            this.vendor = vendor;
            return this;
        }

        public Builder withVid(int vid) {
            this.vid = vid;
            return this;
        }

        public UcsEquipmentRackEnclosure build() {
            return new UcsEquipmentRackEnclosure(this);
        }

    }
}

