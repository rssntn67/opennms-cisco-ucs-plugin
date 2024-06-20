package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.util.Objects;

public class Aggregate {

    private final BigDecimal min;
    private final BigDecimal max;
    private final BigDecimal average;

    private Aggregate(final Builder builder) {
        this.min = Objects.requireNonNull(builder.min);
        this.max = Objects.requireNonNull(builder.max);
        this.average = Objects.requireNonNull(builder.average);
    }

    public static class Builder {
        private BigDecimal min = null;
        private BigDecimal max = null;
        private BigDecimal average = null;

        public Builder withMin(BigDecimal min) {
            this.min = min;
            return this;
        }

        public Builder withMax(BigDecimal max) {
            this.max = max;
            return this;
        }

        public Builder withAverage(BigDecimal average) {
            this.average = average;
            return this;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Aggregate build() {
            return new Aggregate(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public BigDecimal getMin() {
        return min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public BigDecimal getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("min", min)
                .add("max", max)
                .add("average", average)
                .toString();
    }
}
