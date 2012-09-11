package org.geo.spatialsearch.census.model;

import javax.persistence.Column;

import org.geo.spatialsearch.model.GeoBaseEntity;

/**
 * 
 * @author Juan Marin
 * 
 */
public class State2010 extends GeoBaseEntity {

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
