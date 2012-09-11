package org.geo.spatialsearch.service.impl;

import org.geo.spatialsearch.census.model.CensusGeoBaseObject;
import org.geo.spatialsearch.census.model.CensusGeographyEnum;
import org.geo.spatialsearch.census.model.State2010;
import org.geo.spatialsearch.census.rest.CensusLookupResponse;
import org.geo.spatialsearch.dao.HibernateDAO;
import org.geo.spatialsearch.service.CensusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CensusServiceImpl implements CensusService {

    @Autowired
    @Qualifier("state2010DAO")
    private HibernateDAO<State2010, Long> state2010DAO;
    
    @Override
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
    public CensusLookupResponse findByCoordinates(
            CensusGeographyEnum geographyType, double latitude, double longitude) {
        // TODO Auto-generated method stub
        return null;
    }

}
