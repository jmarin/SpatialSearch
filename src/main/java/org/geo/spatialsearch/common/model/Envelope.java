package org.geo.spatialsearch.common.model;

import java.io.Serializable;

public class Envelope implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6722755323693035564L;

	private double minx;
	
	private double maxx;
	
	private double miny;
	
	private double maxy;
	
	public Envelope(){}
	
	public Envelope (com.vividsolutions.jts.geom.Envelope env){
		this.minx = env.getMinX();
		this.maxx = env.getMaxX();
		this.miny = env.getMinY();
		this.maxy = env.getMaxY();
	}

	public double getMinx() {
		return minx;
	}

	public void setMinx(double minx) {
		this.minx = minx;
	}

	public double getMaxx() {
		return maxx;
	}

	public void setMaxx(double maxx) {
		this.maxx = maxx;
	}

	public double getMiny() {
		return miny;
	}

	public void setMiny(double miny) {
		this.miny = miny;
	}

	public double getMaxy() {
		return maxy;
	}

	public void setMaxy(double maxy) {
		this.maxy = maxy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
