package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.Comparator;

public class UcsDnComparator implements Comparator<UcsDn> {
    @Override
    public int compare(UcsDn o1, UcsDn o2) {
        if (o1.equals(o2))
            return 0;
        if (o2.isParent(o1))
            return -1;
        if (o1.isParent(o2))
            return 1;
        if (o1.value.length() == o2.value.length())
            return o1.value.compareTo(o2.value);
        return o2.value.length() - o1.value.length();
    }
}
