package org.geo.spatialsearch.rest.integration;

import org.junit.After;
import org.junit.Before;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RestfulTest {

    public static final String URI = "http://localhost:8081/spatialsearch";

    private Client client;
    protected WebResource webResource;

    @Before
    public void setUp() throws Exception {
        client = new Client();
        webResource = client.resource(RestfulTest.URI);
    }

    @After
    public void tearDown() throws Exception {
    }

}
