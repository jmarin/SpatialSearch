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
@XmlType(name = "Block")
@XmlRootElement(name = "Block")
@Entity
@Table(name = "block2010", schema = "census")
public class Block2010 extends CensusGeoBaseObject {

    @Column(name = "STATEFP10")
    private String statefp;

    @Column(name = "COUNTYFP10")
    private String countyfp;

    @Column(name = "GEOID10")
    private String geoid;

    public String getStatefp() {
        return statefp;
    }

    public void setStatefp(String statefp) {
        this.statefp = statefp;
    }

    public String getCountyfp() {
        return countyfp;
    }

    public void setCountyfp(String countyfp) {
        this.countyfp = countyfp;
    }

    public String getGeoid() {
        return geoid;
    }

    public void setGeoid(String geoid) {
        this.geoid = geoid;
    }

}
