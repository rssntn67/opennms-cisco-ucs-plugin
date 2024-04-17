#! /bin/sh
ls templates | while read file; do echo "./generate-snmp-table-tracker.sh $file > ../plugin/src/main/java/it/xeniaprogetti/cisco/ucs/plugin/snmp/${file}Tracker.java"; done
