package org.geo.spatialsearch.common.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;

@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
public class GeoBaseObject extends BaseObject {

	@Column(name = "geom")
	@Type(type = "org.hibernate.spatial.GeometryType")
	@XmlTransient
	private Geometry geometry;

	@Transient
	@XmlElement
	private Envelope envelope;

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setEnvelope(Envelope envelope) {
		this.envelope = envelope;
	}

	public Envelope getEnvelope() {
		return envelope;
	}
}
