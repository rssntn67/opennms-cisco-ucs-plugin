#! /bin/sh
echo "package it.xeniaprogetti.cisco.ucs.plugin.snmp;"
echo ""
echo "import org.opennms.netmgt.snmp.SnmpInstId;"
echo "import org.opennms.netmgt.snmp.SnmpObjId;"
echo "import org.opennms.netmgt.snmp.SnmpRowResult;"
echo "import org.opennms.netmgt.snmp.TableTracker;"
echo ""
echo "/*"
cat templates/$1
echo ""
echo "*/"
echo "public class $1Tracker extends TableTracker {"

echo ""
awk {'print "    public static final String " $2 " = \""$2"\";"'} templates/$1
echo ""
awk {'print "    public static final SnmpObjId " $2 "ObjId = SnmpObjId.get(\""$1"\");"'} templates/$1

echo "    public static final SnmpObjId[] s_elemList = new SnmpObjId[]{"
awk {'print "            " $2 "ObjId,"'} templates/$1
echo "    };"
echo ""
echo "    public $1Tracker() {"
echo "        super(s_elemList);"
echo "    }"
echo ""
echo "    @Override"
echo "    public SnmpRowResult createRowResult(final int columnCount, final SnmpInstId instance) {"
echo "        return new $1Row(columnCount, instance);"
echo "    }"
echo ""
echo "    @Override"
echo "    public void rowCompleted(final SnmpRowResult row) {"
echo "        process$1Row(($1Row)row);"
echo "    }"
echo ""
echo "    private void process$1Row($1Row row) {"
awk {' print "        System.out.printf(\"\\t\\t%s (%s)= %s (%s)\\n\", " $2 "ObjId + \".\" + row.getInstance().toString(), " $2 ", row.get" toupper(substr($2,1,1)) substr($2,2)"(), \"STRING\");"'} templates/$1
echo "    }"
echo ""
echo "    public static class $1Row extends SnmpRowResult {"
echo ""
echo "         public $1Row(int columnCount, SnmpInstId instance) {"
echo "             super(columnCount, instance);"
echo "         }"
echo ""
echo ""
awk {'print "        public String get"toupper(substr($2,1,1)) substr($2,2)"() {\n            return getValue("$2"ObjId).toString();\n        }\n"'} templates/$1
echo "    }"

echo "}"
