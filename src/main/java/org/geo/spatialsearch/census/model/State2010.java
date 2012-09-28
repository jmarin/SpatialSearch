package org.geo.spatialsearch.census.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Juan Marin
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "State")
@XmlRootElement(name = "State")
@Entity
@Table(name = "state2000", schema = "census")
public class State2010 extends CensusGeoBaseObject {

    @Column(name = "USPS10")
    private String stusps;

    @Column(name = "GEOID10")
    private String geoid;

    @Column(name = "NAME10")
    private String name;

    public String getStusps() {
        return stusps;
    }

    public void setStusps(String stusps) {
        this.stusps = stusps;
    }

    public String getGeoid() {
        return geoid;
    }

    public void setGeoid(String geoid) {
        this.geoid = geoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
