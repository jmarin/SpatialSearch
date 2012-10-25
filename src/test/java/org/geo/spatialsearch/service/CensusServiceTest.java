package org.geo.spatialsearch.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.geo.spatialsearch.census.model.Block2010;
import org.geo.spatialsearch.census.model.CensusGeographyEnum;
import org.geo.spatialsearch.census.model.County2010;
import org.geo.spatialsearch.census.model.State2010;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vividsolutions.jts.geom.Coordinate;

@RunWith(SpringJUnit4ClassRunner.class)
// specifies the Spring configuration to load for this test fixture
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class CensusServiceTest {

    @Autowired
    @Qualifier("censusService")
    public CensusService censusService;

    @Test
    public void testStateById() {
        Long id = 1L;
        State2010 state = (State2010) censusService.findById(
                CensusGeographyEnum.STATE2010, id);
        assertNotNull(state);
        assertEquals(state.getGeoid(), "36");
    }

    @Test
    public void testStateByPoint() {
        Coordinate coordinate = new Coordinate();
        coordinate.x = -73.9813281969;
        coordinate.y = 40.7557761697;
        List<State2010> states = censusService
                .findByCoordinates(CensusGeographyEnum.STATE2010, coordinate.x,
                        coordinate.y).getCensusLookupBaseResponse().getStates();
        Assert.assertFalse(states.isEmpty());
        State2010 state2010 = states.get(0);
        assertEquals(state2010.getName().trim(), "New York");
    }

    @Test
    public void testCountyById() {
    	Long id = 1L;
        County2010 county = (County2010) censusService.findById(
                CensusGeographyEnum.COUNTY2010, id);
        assertNotNull(county);
        assertEquals(county.getGeoid(), "36065");
    }
    
    @Test
    public void testCountyByPoint() {
    	
    }
    
    
    @Test
    public void testBlockById() {
        Long id = 1L;
        Block2010 block = (Block2010) censusService.findById(
                CensusGeographyEnum.BLOCK2010, id);
        assertNotNull(block);
        assertEquals(block.getGeoid(), "360010019012001");
    }

    @Test
    public void testBlock2000ByCoordinates() {
        Coordinate coordinate = new Coordinate();
        coordinate.x = -73.781;
        coordinate.y = 42.649;
        List<Block2010> blocks = censusService
                .findByCoordinates(CensusGeographyEnum.BLOCK2010, coordinate.x,
                        coordinate.y).getCensusLookupBaseResponse().getBlocks();
        Assert.assertFalse(blocks.isEmpty());
        Block2010 block = blocks.get(0);
        assertEquals(block.getStatefp(), "36");
        assertEquals(block.getGeoid(), "360010019012001");
    }

}
