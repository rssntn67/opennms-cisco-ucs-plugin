package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import org.checkerframework.checker.units.qual.A;

import java.math.BigDecimal;
import java.util.Date;

public class UcsSwEnvStats extends UcsStats {

    public static Builder builder() {
       return new Builder();
    }

    public final String donner;
    public final String donnerAvg;
    public final String donnerMax;
    public final String donnerMin;
    public final String fanCtrlrInlet1;
    public final String fanCtrlrInlet1Avg;
    public final String fanCtrlrInlet1Max;
    public final String fanCtrlrInlet1Min;
    public final String fanCtrlrInlet2;
    public final String fanCtrlrInlet2Avg;
    public final String fanCtrlrInlet2Max;
    public final String fanCtrlrInlet2Min;
    public final String fanCtrlrInlet3;
    public final String fanCtrlrInlet3Avg;
    public final String fanCtrlrInlet3Max;
    public final String fanCtrlrInlet3Min;
    public final String fanCtrlrInlet4;
    public final String fanCtrlrInlet4Avg;
    public final String fanCtrlrInlet4Max;
    public final String fanCtrlrInlet4Min;
    public final double mainBoardOutlet1;
    public final Aggregate mainBoardOutlet1Agg;
    public final double mainBoardOutlet2;
    public final Aggregate mainBoardOutlet2Agg;
    public final String psuCtrlrInlet1;
    public final String psuCtrlrInlet1Avg;
    public final String psuCtrlrInlet1Max;
    public final String psuCtrlrInlet1Min;
    public final String psuCtrlrInlet2;
    public final String psuCtrlrInlet2Avg;
    public final String psuCtrlrInlet2Max;
    public final String psuCtrlrInlet2Min;
    public final String td2;
    public final String td2Avg;
    public final String td2Max;
    public final String td2Min;
    public final String tiburon;
    public final String tiburonAvg;
    public final String tiburonMax;
    public final String tiburonMin;

    private UcsSwEnvStats(Builder builder) {
        super(builder.dn, UcsEnums.ClassId.swEnvStats, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);
        donner = builder.donner;
        donnerAvg = builder.donnerAvg;
        donnerMax = builder.donnerMax;
        donnerMin = builder.donnerMin;
        fanCtrlrInlet1 = builder.fanCtrlrInlet1;
        fanCtrlrInlet1Avg = builder.fanCtrlrInlet1Avg;
        fanCtrlrInlet1Max = builder.fanCtrlrInlet1Max;
        fanCtrlrInlet1Min = builder.fanCtrlrInlet1Min;
        fanCtrlrInlet2 = builder.fanCtrlrInlet2;
        fanCtrlrInlet2Avg = builder.fanCtrlrInlet2Avg;
        fanCtrlrInlet2Max = builder.fanCtrlrInlet2Max;
        fanCtrlrInlet2Min = builder.fanCtrlrInlet2Min;
        fanCtrlrInlet3 = builder.fanCtrlrInlet3;
        fanCtrlrInlet3Avg = builder.fanCtrlrInlet3Avg;
        fanCtrlrInlet3Max = builder.fanCtrlrInlet3Max;
        fanCtrlrInlet3Min = builder.fanCtrlrInlet3Min;
        fanCtrlrInlet4 = builder.fanCtrlrInlet4;
        fanCtrlrInlet4Avg = builder.fanCtrlrInlet4Avg;
        fanCtrlrInlet4Max = builder.fanCtrlrInlet4Max;
        fanCtrlrInlet4Min = builder.fanCtrlrInlet4Min;
        mainBoardOutlet1 = builder.mainBoardOutlet1;
        mainBoardOutlet1Agg = Aggregate.builder()
                .withMin(BigDecimal.valueOf(builder.mainBoardOutlet1Min))
                .withAverage(BigDecimal.valueOf(builder.mainBoardOutlet1Avg))
                .withMax(BigDecimal.valueOf(builder.mainBoardOutlet1Max))
                .build();
        mainBoardOutlet2 = builder.mainBoardOutlet2;
        mainBoardOutlet2Agg = Aggregate.builder()
                .withMin(BigDecimal.valueOf(builder.mainBoardOutlet2Min))
                .withAverage(BigDecimal.valueOf(builder.mainBoardOutlet2Avg))
                .withMax(BigDecimal.valueOf(builder.mainBoardOutlet2Max))
                .build();
        psuCtrlrInlet1 = builder.psuCtrlrInlet1;
        psuCtrlrInlet1Avg = builder.psuCtrlrInlet1Avg;
        psuCtrlrInlet1Max = builder.psuCtrlrInlet1Max;
        psuCtrlrInlet1Min = builder.psuCtrlrInlet1Min;
        psuCtrlrInlet2 = builder.psuCtrlrInlet2;
        psuCtrlrInlet2Avg = builder.psuCtrlrInlet2Avg;
        psuCtrlrInlet2Max = builder.psuCtrlrInlet2Max;
        psuCtrlrInlet2Min = builder.psuCtrlrInlet2Min;
        td2 = builder.td2;
        td2Avg = builder.td2Avg;
        td2Max = builder.td2Max;
        td2Min = builder.td2Min;
        tiburon = builder.tiburon;
        tiburonAvg = builder.tiburonAvg;
        tiburonMax = builder.tiburonMax;
        tiburonMin = builder.tiburonMin;
    }

    public static class Builder {
        private Builder() {

        }

        private UcsDn dn;
        public long intervals;
        public String suspect;
        public String thresholded;
        public Date timeCollected;
        public long update;

        private String donner;
        private String donnerAvg;
        private String donnerMax;
        private String donnerMin;
        private String fanCtrlrInlet1;
        private String fanCtrlrInlet1Avg;
        private String fanCtrlrInlet1Max;
        private String fanCtrlrInlet1Min;
        private String fanCtrlrInlet2;
        private String fanCtrlrInlet2Avg;
        private String fanCtrlrInlet2Max;
        private String fanCtrlrInlet2Min;
        private String fanCtrlrInlet3;
        private String fanCtrlrInlet3Avg;
        private String fanCtrlrInlet3Max;
        private String fanCtrlrInlet3Min;
        private String fanCtrlrInlet4;
        private String fanCtrlrInlet4Avg;
        private String fanCtrlrInlet4Max;
        private String fanCtrlrInlet4Min;
        private double mainBoardOutlet1;
        private double mainBoardOutlet1Avg;
        private double mainBoardOutlet1Max;
        private double mainBoardOutlet1Min;
        private double mainBoardOutlet2;
        private double mainBoardOutlet2Avg;
        private double mainBoardOutlet2Max;
        private double mainBoardOutlet2Min;
        private String psuCtrlrInlet1;
        private String psuCtrlrInlet1Avg;
        private String psuCtrlrInlet1Max;
        private String psuCtrlrInlet1Min;
        private String psuCtrlrInlet2;
        private String psuCtrlrInlet2Avg;
        private String psuCtrlrInlet2Max;
        private String psuCtrlrInlet2Min;
        private String td2;
        private String td2Avg;
        private String td2Max;
        private String td2Min;
        private String tiburon;
        private String tiburonAvg;
        private String tiburonMax;
        private String tiburonMin;

        public Builder withDn(String dn) {
            this.dn = UcsDn.getDn(dn);
            return this;
        }

        public Builder withIntervals(long intervals) {
            this.intervals = intervals;
            return this;
        }

        public Builder withSuspect(String suspect) {
            this.suspect = suspect;
            return this;
        }

        public Builder withThresholded(String thresholded) {
            this.thresholded = thresholded;
            return this;
        }

        public Builder withTimeCollected(Date timeCollected) {
            this.timeCollected = timeCollected;
            return this;
        }

        public Builder withUpdate(long update) {
            this.update = update;
            return this;
        }

        public Builder withdonner(String donner){
            this.donner = donner;
            return this;
        }

        public Builder withdonnerAvg(String donnerAvg){
            this.donnerAvg = donnerAvg;
            return this;
        }

        public Builder withdonnerMax(String donnerMax){
            this.donnerMax = donnerMax;
            return this;
        }

        public Builder withdonnerMin(String donnerMin){
            this.donnerMin = donnerMin;
            return this;
        }

        public Builder withfanCtrlrInlet1(String fanCtrlrInlet1){
            this.fanCtrlrInlet1 = fanCtrlrInlet1;
            return this;
        }

        public Builder withfanCtrlrInlet1Avg(String fanCtrlrInlet1Avg){
            this.fanCtrlrInlet1Avg = fanCtrlrInlet1Avg;
            return this;
        }

        public Builder withfanCtrlrInlet1Max(String fanCtrlrInlet1Max){
            this.fanCtrlrInlet1Max = fanCtrlrInlet1Max;
            return this;
        }

        public Builder withfanCtrlrInlet1Min(String fanCtrlrInlet1Min){
            this.fanCtrlrInlet1Min = fanCtrlrInlet1Min;
            return this;
        }

        public Builder withfanCtrlrInlet2(String fanCtrlrInlet2){
            this.fanCtrlrInlet2 = fanCtrlrInlet2;
            return this;
        }

        public Builder withfanCtrlrInlet2Avg(String fanCtrlrInlet2Avg){
            this.fanCtrlrInlet2Avg = fanCtrlrInlet2Avg;
            return this;
        }

        public Builder withfanCtrlrInlet2Max(String fanCtrlrInlet2Max){
            this.fanCtrlrInlet2Max = fanCtrlrInlet2Max;
            return this;
        }

        public Builder withfanCtrlrInlet2Min(String fanCtrlrInlet2Min){
            this.fanCtrlrInlet2Min = fanCtrlrInlet2Min;
            return this;
        }

        public Builder withfanCtrlrInlet3(String fanCtrlrInlet3){
            this.fanCtrlrInlet3 = fanCtrlrInlet3;
            return this;
        }

        public Builder withfanCtrlrInlet3Avg(String fanCtrlrInlet3Avg){
            this.fanCtrlrInlet3Avg = fanCtrlrInlet3Avg;
            return this;
        }

        public Builder withfanCtrlrInlet3Max(String fanCtrlrInlet3Max){
            this.fanCtrlrInlet3Max = fanCtrlrInlet3Max;
            return this;
        }

        public Builder withfanCtrlrInlet3Min(String fanCtrlrInlet3Min){
            this.fanCtrlrInlet3Min = fanCtrlrInlet3Min;
            return this;
        }

        public Builder withfanCtrlrInlet4(String fanCtrlrInlet4){
            this.fanCtrlrInlet4 = fanCtrlrInlet4;
            return this;
        }

        public Builder withfanCtrlrInlet4Avg(String fanCtrlrInlet4Avg){
            this.fanCtrlrInlet4Avg = fanCtrlrInlet4Avg;
            return this;
        }

        public Builder withfanCtrlrInlet4Max(String fanCtrlrInlet4Max){
            this.fanCtrlrInlet4Max = fanCtrlrInlet4Max;
            return this;
        }

        public Builder withfanCtrlrInlet4Min(String fanCtrlrInlet4Min){
            this.fanCtrlrInlet4Min = fanCtrlrInlet4Min;
            return this;
        }

        public Builder withmainBoardOutlet1(double mainBoardOutlet1){
            this.mainBoardOutlet1 = mainBoardOutlet1;
            return this;
        }

        public Builder withmainBoardOutlet1Avg(double mainBoardOutlet1Avg){
            this.mainBoardOutlet1Avg = mainBoardOutlet1Avg;
            return this;
        }

        public Builder withmainBoardOutlet1Max(double mainBoardOutlet1Max){
            this.mainBoardOutlet1Max = mainBoardOutlet1Max;
            return this;
        }

        public Builder withmainBoardOutlet1Min(double mainBoardOutlet1Min){
            this.mainBoardOutlet1Min = mainBoardOutlet1Min;
            return this;
        }

        public Builder withmainBoardOutlet2(double mainBoardOutlet2){
            this.mainBoardOutlet2 = mainBoardOutlet2;
            return this;
        }

        public Builder withmainBoardOutlet2Avg(double mainBoardOutlet2Avg){
            this.mainBoardOutlet2Avg = mainBoardOutlet2Avg;
            return this;
        }

        public Builder withmainBoardOutlet2Max(double mainBoardOutlet2Max){
            this.mainBoardOutlet2Max = mainBoardOutlet2Max;
            return this;
        }

        public Builder withmainBoardOutlet2Min(double mainBoardOutlet2Min){
            this.mainBoardOutlet2Min = mainBoardOutlet2Min;
            return this;
        }

        public Builder withpsuCtrlrInlet1(String psuCtrlrInlet1){
            this.psuCtrlrInlet1 = psuCtrlrInlet1;
            return this;
        }

        public Builder withpsuCtrlrInlet1Avg(String psuCtrlrInlet1Avg){
            this.psuCtrlrInlet1Avg = psuCtrlrInlet1Avg;
            return this;
        }

        public Builder withpsuCtrlrInlet1Max(String psuCtrlrInlet1Max){
            this.psuCtrlrInlet1Max = psuCtrlrInlet1Max;
            return this;
        }

        public Builder withpsuCtrlrInlet1Min(String psuCtrlrInlet1Min){
            this.psuCtrlrInlet1Min = psuCtrlrInlet1Min;
            return this;
        }

        public Builder withpsuCtrlrInlet2(String psuCtrlrInlet2){
            this.psuCtrlrInlet2 = psuCtrlrInlet2;
            return this;
        }

        public Builder withpsuCtrlrInlet2Avg(String psuCtrlrInlet2Avg){
            this.psuCtrlrInlet2Avg = psuCtrlrInlet2Avg;
            return this;
        }

        public Builder withpsuCtrlrInlet2Max(String psuCtrlrInlet2Max){
            this.psuCtrlrInlet2Max = psuCtrlrInlet2Max;
            return this;
        }

        public Builder withpsuCtrlrInlet2Min(String psuCtrlrInlet2Min){
            this.psuCtrlrInlet2Min = psuCtrlrInlet2Min;
            return this;
        }

        public Builder withtd2(String td2){
            this.td2 = td2;
            return this;
        }

        public Builder withtd2Avg(String td2Avg){
            this.td2Avg = td2Avg;
            return this;
        }

        public Builder withtd2Max(String td2Max){
            this.td2Max = td2Max;
            return this;
        }

        public Builder withtd2Min(String td2Min){
            this.td2Min = td2Min;
            return this;
        }

        public Builder withtiburon(String tiburon){
            this.tiburon = tiburon;
            return this;
        }

        public Builder withtiburonAvg(String tiburonAvg){
            this.tiburonAvg = tiburonAvg;
            return this;
        }

        public Builder withtiburonMax(String tiburonMax){
            this.tiburonMax = tiburonMax;
            return this;
        }

        public Builder withtiburonMin(String tiburonMin){
            this.tiburonMin = tiburonMin;
            return this;
        }

        public UcsSwEnvStats build() {
            return new UcsSwEnvStats(this);
        }
    }
}
