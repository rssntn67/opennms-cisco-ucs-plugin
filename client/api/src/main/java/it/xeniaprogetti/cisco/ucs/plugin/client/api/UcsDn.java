package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.nio.file.Paths;
import java.util.Objects;

public class UcsDn {
    public String value;

    private UcsDn(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public boolean isChild(UcsDn parent) {
        return !value.equals(parent.value) && value.startsWith(parent.value);
    }

    public boolean isParent(UcsDn child) {
        return !value.equals(child.value) && child.value.startsWith(value);
    }

    public static UcsDn getDn(String value) {
        return new UcsDn(value);
    }

    public static UcsDn getParentDn(UcsDn dn) {
        if (isRootDn(dn))
            return null;
        return new UcsDn(Paths.get(dn.value).getParent().toString());
    }


    public static boolean isRootDn(UcsDn dn) {
        if (dn == null || dn.value == null)
            return false;
        return Paths.get(dn.value).getParent() == null;
    }

    @Override
    public String toString() {
        return "UcsDn{" + "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UcsDn ucsDn = (UcsDn) o;
        return Objects.equals(value, ucsDn.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
