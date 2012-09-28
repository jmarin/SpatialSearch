package org.geo.spatialsearch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;

/**
 * 
 * @author Juan Marin
 * 
 */
@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
public class GeoBaseEntity implements Serializable {

    @Id
    private Long id;

    @XmlTransient
    @Type(type = "org.hibernate.spatial.GeometryType")
    @Column(name = "geom")
    private Geometry geometry;

    @XmlTransient
    private Envelope envelope;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Envelope getEnvelope() {
        return envelope;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }

}
