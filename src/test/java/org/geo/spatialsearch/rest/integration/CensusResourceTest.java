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
		ClientResponse response = this.webResource.path("census")
				.path("state2010").queryParam("latitude", "42.919")
				.queryParam("longitude", "-75.2517")
				.queryParam("format", "json").get(ClientResponse.class);
		assertEquals(200, response.getStatus()); // 200 = OK

		String json = response.getEntity(String.class);
		JSONObject results = new JSONObject(json);
		JSONObject jo = (JSONObject) results.get("Results");
		JSONArray states = (JSONArray) jo.get("state");
		Assert.assertFalse(states.isNull(0));
		JSONObject state = (JSONObject) states.get(0);

		assertEquals("36", state.get("geoid"));
		assertEquals("New York", state.get("name"));
		assertEquals("NY", state.get("stusps"));
	}

	@Test
	public void testFindCountyByCoordinates() throws JSONException {
		ClientResponse response = this.webResource.path("census")
				.path("county2010").queryParam("latitude", "42.919")
				.queryParam("longitude", "-75.2517")
				.queryParam("format", "json").get(ClientResponse.class);
		assertEquals(200, response.getStatus()); // 200 = OK

		String json = response.getEntity(String.class);
		JSONObject results = new JSONObject(json);
		JSONObject jo = (JSONObject) results.get("Results");
		JSONArray counties = (JSONArray) jo.get("county");
		Assert.assertFalse(counties.isNull(0));
		JSONObject county = (JSONObject) counties.get(0);

		assertEquals("36065", county.get("geoid"));
		assertEquals("Oneida", county.get("name"));
		assertEquals("36", county.get("statefp10"));
	}

	
	
	@Test
	public void testFindBlockByCoordinates() throws JSONException {
		ClientResponse response = this.webResource.path("census")
				.path("block2010").queryParam("latitude", "42.649")
				.queryParam("longitude", " -73.781")
				.queryParam("format", "json").get(ClientResponse.class);
		assertEquals(200, response.getStatus()); // 200 = OK

		String json = response.getEntity(String.class);
		JSONObject results = new JSONObject(json);
		JSONObject jo = (JSONObject) results.get("Results");
		JSONArray blocks = (JSONArray) jo.get("block");
		Assert.assertFalse(blocks.isNull(0));
		JSONObject block = (JSONObject) blocks.get(0);

		assertEquals("360010021002003", block.get("geoid"));
		assertEquals("36", block.get("statefp"));
		assertEquals("001", block.get("countyfp"));

	}
}
