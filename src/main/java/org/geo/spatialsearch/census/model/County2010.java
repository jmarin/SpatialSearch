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
@XmlType(name = "County")
@XmlRootElement(name = "County")
@Entity
@Table(name = "county2010", schema = "census")
public class County2010 extends CensusGeoBaseObject {

	@Column(name = "STATEFP10")
	private String statefp10;

	@Column(name = "GEOID10")
	private String geoid;

	@Column(name = "NAME10")
	private String name;

	public String getStatefp10() {
		return statefp10;
	}

	public void setStatefp10(String statefp10) {
		this.statefp10 = statefp10;
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
