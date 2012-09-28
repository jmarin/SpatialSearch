package org.geo.spatialsearch.rest.integration;

import static junit.framework.Assert.assertEquals;

import junit.framework.Assert;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

public class CensusResourceTest extends RestfulTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testFindStateByCoordinates() throws JSONException {
        ClientResponse response = this.webResource.path("census").path("state")
                .queryParam("latitude", "42.919")
                .queryParam("longitude", "-75.2517")
                .queryParam("format", "json").get(ClientResponse.class);
        assertEquals(200, response.getStatus()); // 200 = OK

        String json = response.getEntity(String.class);
        JSONObject results = new JSONObject(json);
        JSONObject jo = (JSONObject) results.get("Results");
        JSONArray states = (JSONArray) jo.get("state");
        Assert.assertFalse(states.isNull(0));
        JSONObject state = (JSONObject) states.get(0);

        assertEquals("36", state.get("fips"));
        assertEquals("New York", state.get("name"));
        assertEquals("NY", state.get("stateCode"));
        assertEquals("STATE2000", state.get("geographyType"));
    }

}
