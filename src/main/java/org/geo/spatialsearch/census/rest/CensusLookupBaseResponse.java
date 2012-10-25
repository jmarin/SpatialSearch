package org.geo.spatialsearch.census.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.geo.spatialsearch.census.model.Block2010;
import org.geo.spatialsearch.census.model.County2010;
import org.geo.spatialsearch.census.model.State2010;

/**
 * 
 * @author Juan Marin
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CensusLookupBaseResponse {

	@XmlElement(name = "state")
	private List<State2010> states;

	@XmlElement(name = "county")
	private List<County2010> counties;

	@XmlElement(name = "block")
	private List<Block2010> blocks;

	public CensusLookupBaseResponse() {
	}

	public List<State2010> getStates() {
		if (states == null) {
			states = new ArrayList<State2010>();
		}
		return states;
	}

	public void setStates(List<State2010> states) {
		this.states = states;
	}

	public List<County2010> getCounties() {
		if (counties == null) {
			counties = new ArrayList<County2010>();
		}
		return counties;
	}

	public void setCounties(List<County2010> counties) {
		this.counties = counties;
	}

	public List<Block2010> getBlocks() {
		if (blocks == null) {
			blocks = new ArrayList<Block2010>();
		}
		return blocks;
	}

	public void setBlocks(List<Block2010> blocks) {
		this.blocks = blocks;
	}

}