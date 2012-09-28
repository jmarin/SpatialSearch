package org.geo.spatialsearch.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.geo.spatialsearch.rest.exceptions.UnsupportedFormatException;

import com.sun.jersey.api.json.JSONWithPadding;

public class RestFormatUtil {

    public static <T> Response format(String format, String callback, T response) {
        if (format != null) {
            if (format.equals("json")) {
                return Response.ok(response).type(MediaType.APPLICATION_JSON)
                        .build();
            } else if (format.equals("xml")) {
                return Response.ok(response).type(MediaType.APPLICATION_XML)
                        .build();
            } else if (format.equals("jsonp")) {
                return Response.ok()
                        .entity(new JSONWithPadding(response, callback))
                        .type("application/x-javascript").build();
            } else {
                throw new UnsupportedFormatException();
            }
        } else {
            return Response.ok(response.toString())
                    .type(MediaType.APPLICATION_XML).build();
        }
    }
}
