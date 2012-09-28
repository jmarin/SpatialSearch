package org.geo.spatialsearch.service.impl;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.geo.spatialsearch.census.model.CensusGeoBaseObject;
import org.geo.spatialsearch.census.model.CensusGeographyEnum;
import org.geo.spatialsearch.census.model.State2010;
import org.geo.spatialsearch.census.rest.CensusLookupBaseResponse;
import org.geo.spatialsearch.census.rest.CensusLookupResponse;
import org.geo.spatialsearch.dao.HibernateDAO;
import org.geo.spatialsearch.model.Envelope;
import org.geo.spatialsearch.service.CensusService;
import org.geo.spatialsearch.util.GeometryUtil;
import org.geo.spatialsearch.util.Message;
import org.geo.spatialsearch.util.ValidationUtil;
import org.hibernate.Criteria;
import org.hibernate.spatial.criterion.SpatialRestrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.vividsolutions.jts.geom.Point;

@Transactional
public class CensusServiceImpl implements CensusService {

    @Autowired
    @Qualifier("state2010DAO")
    private HibernateDAO<State2010, Long> state2010DAO;

    @Override
    @Transactional(readOnly = true)
    public CensusGeoBaseObject findById(CensusGeographyEnum geographyType,
            Long id) {
        CensusGeoBaseObject geoEntity = null;
        switch (geographyType) {
        case STATE2010:
            geoEntity = state2010DAO.findById(id);
            break;
        }
        return geoEntity;
    }

    @Override
    @Transactional(readOnly = true)
    public CensusLookupResponse findByCoordinates(
            CensusGeographyEnum geographyType, double longitude, double latitude) {

        // WGS84 hard coded for now
        Point point = GeometryUtil.getPoint(longitude, latitude, 4326);
        CensusLookupResponse apiResponse = new CensusLookupResponse();
        CensusLookupBaseResponse censusLookupBaseResponse = new CensusLookupBaseResponse();
        apiResponse.setCensusLookupBaseResponse(censusLookupBaseResponse);
        List<String> messages = apiResponse.getMessageList();
        ValidationUtil.isValidCensusGeographyType(apiResponse, geographyType);
        if (messages.isEmpty()) {
            switch (geographyType) {
            case STATE2010:
                findStateByPoint(apiResponse, point);
                break;
            case COUNTY2010:
                findCountyByPoint(apiResponse, point);
                break;
            case TRACT2010:
                findTractByPoint(apiResponse, point);
                break;
            case BLOCK2010:
                findBlockByPoint(apiResponse, point);
                break;
            case CONGRESSIONAL_DISTRICT:
                findCongressionalDistrictByPoint(apiResponse, point);
                break;
            case MSA:
                findMSAByPoint(apiResponse, point);
                break;
            case PLACE:
                findPlaceByPoint(apiResponse, point);
                break;
            case STATE_HOUSE_DISTRICT:
                findStateHouseDistrictByPoint(apiResponse, point);
                break;
            case STATE_SENATE_DISTRICT:
                findStateSenateDistrictByPoint(apiResponse, point);
                break;
            case TRIBAL:
                findTribalByPoint(apiResponse, point);
                break;
            case ALL:
                findAllByPoint(apiResponse, point);
                break;
            }
            apiResponse.setStatus(Status.OK.getReasonPhrase());
        }
        return apiResponse;
    }

    private void findAllByPoint(CensusLookupResponse apiResponse, Point point) {
        // TODO Auto-generated method stub
        
    }

    private void findTribalByPoint(CensusLookupResponse apiResponse, Point point) {
        // TODO Auto-generated method stub
        
    }

    private void findStateSenateDistrictByPoint(
            CensusLookupResponse apiResponse, Point point) {
        // TODO Auto-generated method stub
        
    }

    private void findStateHouseDistrictByPoint(
            CensusLookupResponse apiResponse, Point point) {
        // TODO Auto-generated method stub
        
    }

    private void findPlaceByPoint(CensusLookupResponse apiResponse, Point point) {
        // TODO Auto-generated method stub
        
    }

    private void findMSAByPoint(CensusLookupResponse apiResponse, Point point) {
        // TODO Auto-generated method stub
        
    }

    private void findCongressionalDistrictByPoint(
            CensusLookupResponse apiResponse, Point point) {
        // TODO Auto-generated method stub
        
    }

    private void findBlockByPoint(CensusLookupResponse apiResponse, Point point) {
        // TODO Auto-generated method stub
        
    }

    private void findTractByPoint(CensusLookupResponse apiResponse, Point point) {
        // TODO Auto-generated method stub
        
    }

    private void findCountyByPoint(CensusLookupResponse apiResponse, Point point) {
        // TODO Auto-generated method stub
        
    }

    @Transactional(readOnly = true)
    private void findStateByPoint(CensusLookupResponse apiResponse, Point point) {
        final Criteria stateCriteria = state2010DAO.createCriteria();
        stateCriteria.add(SpatialRestrictions.contains("geometry", point));
        State2010 state = state2010DAO.findByCriteria(stateCriteria);
        if (state != null) {
            state.setEnvelope(new Envelope(state.getGeometry()
                    .getEnvelopeInternal()));
            apiResponse.getCensusLookupBaseResponse().getStates().add(state);
        }
        ValidationUtil.isEmptyResult(apiResponse, apiResponse
                .getCensusLookupBaseResponse().getStates(),
                Message.NO_STATE_RESULTS_FOUND, null);
    }

}
