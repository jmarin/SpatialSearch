package org.geo.spatialsearch.rest.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public interface CensusResource {

    public Response findByCoordinates(UriInfo uriInfo, String geography,
            double latitude, double longitude, String format, String callback);

    public Response findGeographyByName(UriInfo uriInfo, String geography,
            String geographyName, Integer maxResults, Boolean isFullList,
            String format, String callback);

    public Response findGeographyByFips(UriInfo uriInfo, String geography,
            String fips, String format, String callback);

}
