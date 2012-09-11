package org.geo.spatialsearch.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.geo.spatialsearch.census.model.CensusGeographyEnum;
import org.geo.spatialsearch.census.model.State2010;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//specifies the Spring configuration to load for this test fixture
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })

public class CensusServiceTest {

    @Autowired
    @Qualifier("censusService")
    public CensusService censusService;

    @Test
    public void testStateById() {
        Long id = 1L;
        State2010 state = (State2010) censusService.findById(
               CensusGeographyEnum.STATE2010 , id);
        assertNotNull(state);
        assertEquals(state.getGeoid(), "36");
    }

}
