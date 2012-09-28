package org.geo.spatialsearch.service;

import org.geo.spatialsearch.census.model.CensusGeoBaseObject;
import org.geo.spatialsearch.census.model.CensusGeographyEnum;
import org.geo.spatialsearch.census.rest.CensusLookupResponse;

/**
 * 
 * @author Juan Marin
 * 
 */
public interface CensusService {

    public CensusGeoBaseObject findById(CensusGeographyEnum geographyType,
            Long id);

    public CensusLookupResponse findByCoordinates(
            CensusGeographyEnum geographyType, double longitude, double latitude);
}
