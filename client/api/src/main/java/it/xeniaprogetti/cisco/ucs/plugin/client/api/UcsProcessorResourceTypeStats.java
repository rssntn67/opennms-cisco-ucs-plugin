package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public abstract class UcsProcessorResourceTypeStats extends UcsResourceTypeStats {

    public UcsProcessorResourceTypeStats(UcsDn dn, UcsEnums.ClassId classId, UcsEnums.ClassItem classItem, long intervals, String suspect, String thresholded, Date timeCollected, long update) {
        super(dn, classId, classItem, intervals, suspect, thresholded, timeCollected, update);
    }

    @Override
    public UcsEnums.ResourceType getResourceType() {
        return UcsEnums.ResourceType.CiscoUcsProcessor;
    }
}