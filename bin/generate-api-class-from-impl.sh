#!/bin/bash
className=$1
target=../client/api/src/main/java/it/xeniaprogetti/cisco/ucs/plugin/client/api/Ucs$1.java
source=../client/impl/src/main/java/it/xeniaprogetti/cisco/ucs/plugin/client/impl/model/stats/$1.java 
echo "package it.xeniaprogetti.cisco.ucs.plugin.client.api;" > $target
echo "" >>$target
echo "import java.util.Date;" >>$target
echo "" >>$target
echo "public class Ucs$className extends UcsStats {" >>$target
echo "" >>$target
echo "    public static Builder builder() {" >>$target
echo "       return new Builder();" >>$target
echo "    }" >>$target
echo "" >>$target
grep public $source | grep -v $className | sed -e "s/public/public final/g" >>$target
echo "" >>$target
echo "    private Ucs$className(Builder builder) {" >>$target
echo "        super(builder.dn, UcsEnums.ClassId.$className, UcsEnums.ClassItem.statsItem, builder.intervals, builder.suspect, builder.thresholded, builder.timeCollected, builder.update);" >>$target
grep public $source | grep -v $className | sed -e "s/;//g" |awk '{ print "        "$3" = builder."$3";"}' >>$target
echo "    }" >>$target
echo "" >>$target
echo "    public static class Builder {" >>$target
echo "        private Builder() {" >>$target
echo "" >>$target
echo "        }" >>$target
echo "" >>$target
echo "        private UcsDn dn;" >>$target
echo "        public long intervals;" >>$target
echo "        public String suspect;" >>$target
echo "        public String thresholded;" >>$target
echo "        public Date timeCollected;" >>$target
echo "        public long update;" >>$target
echo "" >>$target
grep public $source | grep -v $className | sed -e "s/;//g" |awk '{ print "        private "$2" "$3";"}' >>$target
echo "" >>$target
echo "        public Builder withDn(String dn) {" >>$target
echo "            this.dn = UcsDn.getDn(dn);" >>$target
echo "            return this;" >>$target
echo "        }" >>$target
echo "" >>$target
echo "        public Builder withIntervals(long intervals) {" >>$target
echo "            this.intervals = intervals;" >>$target
echo "            return this;" >>$target
echo "        }" >>$target
echo "" >>$target
echo "        public Builder withSuspect(String suspect) {" >>$target
echo "            this.suspect = suspect;" >>$target
echo "            return this;" >>$target
echo "        }" >>$target
echo "" >>$target
echo "        public Builder withThresholded(String thresholded) {" >>$target
echo "            this.thresholded = thresholded;" >>$target
echo "            return this;" >>$target
echo "        }" >>$target
echo "" >>$target
echo "        public Builder withTimeCollected(Date timeCollected) {" >>$target
echo "            this.timeCollected = timeCollected;" >>$target
echo "            return this;" >>$target
echo "        }" >>$target
echo "" >>$target
echo "        public Builder withUpdate(long update) {" >>$target
echo "            this.update = update;" >>$target
echo "            return this;" >>$target
echo "        }" >>$target
echo "" >>$target
grep public $source | grep -v $className | sed -e "s/;//g" |awk '{ print "        public Builder with"$3"("$2" "$3"){\n            this."$3" = "$3 ";\n            return this;\n        }\n"}' >>$target
echo "        public Ucs$className build() {" >>$target
echo "            return new Ucs$className(this);" >>$target
echo "        }" >>$target
echo "    }" >>$target
echo "}" >>$target
