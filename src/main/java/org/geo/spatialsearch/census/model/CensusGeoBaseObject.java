package org.geo.spatialsearch.census.model;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;

import org.geo.spatialsearch.model.GeoBaseEntity;

/**
 * 
 * @author Juan Marin
 * 
 */
public class CensusGeoBaseObject extends GeoBaseEntity {

    @XmlElement
    @Transient
    private CensusGeographyEnum geographyType;

    public void setGeographyType(CensusGeographyEnum geographyType) {
        this.geographyType = geographyType;
    }

    public CensusGeographyEnum getGeographyType() {
        return geographyType;
    }

}
