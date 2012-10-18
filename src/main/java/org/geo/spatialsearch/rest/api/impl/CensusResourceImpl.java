package org.geo.spatialsearch.rest.api.impl;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.geo.spatialsearch.census.model.CensusGeographyEnum;
import org.geo.spatialsearch.census.rest.CensusLookupResponse;
import org.geo.spatialsearch.rest.api.CensusResource;
import org.geo.spatialsearch.service.CensusService;
import org.geo.spatialsearch.util.ExceptionHandler;
import org.geo.spatialsearch.util.RestFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.yammer.metrics.annotation.Timed;

/**
 * 
 * @author Juan Marin
 * 
 */

@Path(value = "/census")
@Component
@Scope(value = "singleton")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
        "application/x-javascript" })
@Api(value = "census", basePath = "/census", description = "Census API")
public class CensusResourceImpl implements CensusResource {

    @Autowired
    @Qualifier("censusService")
    private CensusService censusService;

    @Autowired
    @Qualifier("exceptionHandler")
    private ExceptionHandler handler;

    // private static final String CENSUS_BY_COORDINATES =
    // "Census-findByCoordinates";
    // private static final String CENSUS_BY_FIPSCODE =
    // "Census-findGeographyByFips";
    // private static final String CENSUS_BY_GEOGRAPHY_NAME =
    // "Census-findGeographyByName";

    @Override
    @Path(value = "{geography}")
    @GET
    @Timed
    @ApiOperation(value = "Find Geography by Coordinates", notes = "Returns a Census Geography at a certain latitude, longitude", httpMethod = "GET")
    public Response findByCoordinates(
            @Context UriInfo uriInfo,
            @ApiParam(value = "geography", required = true) @PathParam(value = "geography") String geography,
            @ApiParam(value = "latitude", required = true) @QueryParam(value = "latitude") double latitude,
            @ApiParam(value = "longitude", required = true) @QueryParam(value = "longitude") double longitude,
            @ApiParam(value = "format", required = false) @DefaultValue("xml") @QueryParam(value = "format") String format,
            @ApiParam(value = "callback", required = false) @QueryParam(value = "callback") String callback) {
        CensusGeographyEnum geographyType = CensusGeographyEnum
                .getGeographyTypeWithKey(geography);
        CensusLookupResponse apiResponse = new CensusLookupResponse();
        Exception exception = null;
        try {
            apiResponse = censusService.findByCoordinates(geographyType,
                    longitude, latitude);
        } catch (Exception ex) {
            handler.handle(apiResponse, ex);
            exception = ex;
        }
        // APIStatsProfiler.captureStatistics(CENSUS_BY_COORDINATES,
        // apiResponse,uriInfo, true, exception);
        Response response = RestFormatUtil
                .format(format, callback, apiResponse);
        return response;
    }

    @Override
    public Response findGeographyByName(UriInfo uriInfo, String geography,
            String geographyName, Integer maxResults, Boolean isFullList,
            String format, String callback) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response findGeographyByFips(UriInfo uriInfo, String geography,
            String fips, String format, String callback) {
        // TODO Auto-generated method stub
        return null;
    }

}
