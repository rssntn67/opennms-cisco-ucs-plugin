#!/bin/bash
className=$1
target=../client/api/src/main/java/it/xeniaprogetti/cisco/ucs/plugin/client/api/Ucs$1
source=../client/impl/src/main/java/it/xeniaprogetti/cisco/ucs/plugin/client/impl/model/stats/$1.java 
statssource=../client/impl/src/main/java/it/xeniaprogetti/cisco/ucs/plugin/client/impl/model/stats/Stats.java 
echo "package it.xeniaprogetti.cisco.ucs.plugin.client.api;"
echo ""
echo "public $className extends UcsStats {"
echo ""
grep public $source | grep -v $className | sed -e "s/public/public final/g"
echo ""
echo "    public static Builder builder() {"
echo "       return new Builder();"
echo "    }"
echo ""
grep public $source | grep -v $className | sed -e "s/public/public final/g"
echo ""
echo "    private $className(Builder builder) {"
echo "       super(builder.dn, builder.class
grep public $source | grep -v $className | sed -e "s/;//g" |awk '{ print "        "$3" = builder."$3";"}'
echo "    }"
echo ""
echo "    public static class Builder {"
echo "        private Builder() {"
echo ""
echo "        }"
echo ""
grep public $source | grep -v $className | sed -e "s/;//g" |awk '{ print "        private "$2" "$3";"}'
echo "    }"

echo "}" 
