package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.nio.file.Paths;
import java.util.Objects;

public class Dn {
    @JacksonXmlProperty(isAttribute = true)
    public String value;

    public Dn() {

    }

    private Dn(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static Dn getDn(String value) {
        return new Dn(value);
    }

    public static Dn getParentDn(Dn dn) {
        if (isRootDn(dn))
            return null;
        return new Dn(Paths.get(dn.value).getParent().toString());
    }

    public static boolean isRootDn(Dn dn) {
        if (dn == null || dn.value == null)
            return false;
        return Paths.get(dn.value).getParent() == null;
    }

    @Override
    public String toString() {
        return "Dn{" + "value='" + value + '\'' +
                '}';
    }
}
