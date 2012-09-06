package org.geo.spatialsearch.common.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseObject implements IEntity<Long> {

	@Id
	@Column(name = "id")
	@XmlTransient
	protected Long id;

	/**
	 * @return Returns the id.
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * @param id The id to set.
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
