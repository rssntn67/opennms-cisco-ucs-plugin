package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Date;

public abstract class UcsStats extends UcsEntity {
    public final long intervals;
    public final String suspect;
    public final String thresholded;
    public final Date timeCollected;
    public final long update;

    public UcsStats(UcsDn dn, UcsEnums.ClassId classId, UcsEnums.ClassItem classItem, long intervals, String suspect, String thresholded, Date timeCollected, long update) {
        super(dn, classId, classItem);
        this.intervals = intervals;
        this.suspect = suspect;
        this.thresholded = thresholded;
        this.timeCollected = timeCollected;
        this.update = update;
    }
}
