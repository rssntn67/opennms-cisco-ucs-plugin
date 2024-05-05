package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.time.OffsetDateTime;

public class UcsFault extends UcsEntity {


    private UcsFault(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.faultInst, UcsEnums.ClassItem.otherItem);
        this.ack = builder.ack;
        this.cause = builder.cause;
        this.changeSet = builder.changeSet;
        this.code = builder.code;
        this.created = builder.created;
        this.descr = builder.descr;
        this.highestSeverity = builder.highestSeverity;
        this.id = builder.id;
        this.lastTransition = builder.lastTransition;
        this.lc = builder.lc;
        this.occur = builder.occur;
        this.origSeverity = builder.origSeverity;
        this.prevSeverity = builder.prevSeverity;
        this.rule = builder.rule;
        this.severity = builder.severity;
        this.tags = builder.tags;
        this.type = builder.type;
    }

    public enum Severity {
        critical, major, minor, warning, condition, info, cleared
    }

    public enum Type {
        generic,
        equipment,
        environmental,
        management,
        fsm,
        sysdebug,
        configuration,
        server,
        network,
        connectivity,
        operational
    }

    public static Builder builder() {
        return new Builder();
    }

    public final String ack;
    public final String cause;
    public final String changeSet;
    public final String code;
    public final OffsetDateTime created;
    public final String descr;
    public final Severity highestSeverity;
    public final long id;
    public final OffsetDateTime lastTransition;
    public final String lc;
    public final int occur;
    public final Severity origSeverity;
    public final Severity prevSeverity;
    public final String rule;
    public final Severity severity;
    public final String tags;
    public final Type type;

    public static class Builder {
        private Builder() {

        }

        private UcsDn dn;
        private String ack;
        private String cause;
        private String changeSet;
        private String code;
        private OffsetDateTime created;
        private String descr;
        private Severity highestSeverity;
        private long id;
        private OffsetDateTime lastTransition;
        private String lc;
        private int occur;
        private Severity origSeverity;
        private Severity prevSeverity;
        private String rule;
        private Severity severity;
        private String tags;
        private Type type;

        public Builder withDn(String dn) {
            this.dn = UcsDn.getDn(dn);
            return this;
        }

        public Builder withAck(String ack) {
            this.ack = ack;
            return this;
        }

        public Builder withCause(String cause) {
            this.cause = cause;
            return this;
        }

        public Builder withChangeSet(String changewith) {
            this.changeSet = changewith;
            return this;
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withCreated(OffsetDateTime created) {
            this.created = created;
            return this;
        }

        public Builder withDescr(String descr) {
            this.descr = descr;
            return this;
        }

        public Builder withHighestSeverity(Severity highestSeverity) {
            this.highestSeverity = highestSeverity;
            return this;
        }

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withLastTransition(OffsetDateTime lastTransition) {
            this.lastTransition = lastTransition;
            return this;
        }

        public Builder withLc(String lc) {
            this.lc = lc;
            return this;
        }

        public Builder withOccur(int occur) {
            this.occur = occur;
            return this;
        }

        public Builder withOrigSeverity(Severity origSeverity) {
            this.origSeverity = origSeverity;
            return this;
        }

        public Builder withPrevSeverity(Severity prevSeverity) {
            this.prevSeverity = prevSeverity;
            return this;
        }

        public Builder withRule(String rule) {
            this.rule = rule;
            return this;
        }

        public Builder withSeverity(Severity severity) {
            this.severity = severity;
            return this;
        }

        public Builder withTags(String tags) {
            this.tags = tags;
            return this;
        }

        public Builder withType(Type type) {
            this.type = type;
            return this;
        }

        public UcsFault build() {
            return new UcsFault(this);
        }
    }
}
