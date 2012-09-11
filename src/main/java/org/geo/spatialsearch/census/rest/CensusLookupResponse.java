package org.geo.spatialsearch.census.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.geo.spatialsearch.rest.APIResponse;

/**
 * 
 * @author Juan Marin
 * 
 */

@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class CensusLookupResponse extends APIResponse {

    @XmlElement(name = "Results")
    private CensusLookupBaseResponse censusLookupBaseResponse;

    public CensusLookupResponse() {
    }

    public CensusLookupBaseResponse getCensusLookupBaseResponse() {
        return censusLookupBaseResponse;
    }

    public void setCensusLookupBaseResponse(
            CensusLookupBaseResponse censusLookupBaseResponse) {
        this.censusLookupBaseResponse = censusLookupBaseResponse;
    }
}