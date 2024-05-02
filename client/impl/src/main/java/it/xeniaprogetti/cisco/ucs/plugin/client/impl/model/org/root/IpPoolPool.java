package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class IpPoolPool {
    @JacksonXmlProperty()
    public IpPoolBlock ippoolBlock;
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<IpPoolPooled> ippoolPooled;
    @JacksonXmlProperty(isAttribute = true)
    public int assigned;
    @JacksonXmlProperty(isAttribute = true)
    public String assignmentOrder;
    @JacksonXmlProperty(isAttribute = true)
    public String childAction;
    @JacksonXmlProperty(isAttribute = true)
    public String descr;
    @JacksonXmlProperty(isAttribute = true)
    public String dn;
    @JacksonXmlProperty(isAttribute = true)
    public String extManaged;
    @JacksonXmlProperty(isAttribute = true)
    public String guid;
    @JacksonXmlProperty(isAttribute = true)
    public int intId;
    @JacksonXmlProperty(isAttribute = true)
    public String isNetBIOSEnabled;
    @JacksonXmlProperty(isAttribute = true)
    public String name;
    @JacksonXmlProperty(isAttribute = true)
    public int policyLevel;
    @JacksonXmlProperty(isAttribute = true)
    public String policyOwner;
    @JacksonXmlProperty(isAttribute = true)
    public int propAcl;
    @JacksonXmlProperty(isAttribute = true)
    public int size;
    @JacksonXmlProperty(isAttribute = true)
    public String supportsDHCP;
    @JacksonXmlProperty(isAttribute = true)
    public int v4Assigned;
    @JacksonXmlProperty(isAttribute = true)
    public int v4Size;
    @JacksonXmlProperty(isAttribute = true)
    public int v6Assigned;
    @JacksonXmlProperty(isAttribute = true)
    public int v6Size;

    @Override
    public String toString() {
        return "IpPoolPool{" +
                "ippoolBlock=" + ippoolBlock +
                ", ippoolPooled=" + ippoolPooled +
                ", assigned=" + assigned +
                ", assignmentOrder='" + assignmentOrder + '\'' +
                ", childAction='" + childAction + '\'' +
                ", descr='" + descr + '\'' +
                ", dn='" + dn + '\'' +
                ", extManaged='" + extManaged + '\'' +
                ", guid='" + guid + '\'' +
                ", intId=" + intId +
                ", isNetBIOSEnabled='" + isNetBIOSEnabled + '\'' +
                ", name='" + name + '\'' +
                ", policyLevel=" + policyLevel +
                ", policyOwner='" + policyOwner + '\'' +
                ", propAcl=" + propAcl +
                ", size=" + size +
                ", supportsDHCP='" + supportsDHCP + '\'' +
                ", v4Assigned=" + v4Assigned +
                ", v4Size=" + v4Size +
                ", v6Assigned=" + v6Assigned +
                ", v6Size=" + v6Size +
                '}';
    }
}
