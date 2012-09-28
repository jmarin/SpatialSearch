package org.geo.spatialsearch.rest.exceptions;

import javax.ws.rs.QueryParam;

import com.sun.jersey.api.ParamException;
import com.sun.jersey.api.Responses;

public class UnsupportedFormatException extends ParamException {

    private static final long serialVersionUID = 1160004452288344472L;

    /**
     * Create a HTTP 415 (Unsupported Media Type) exception.
     */
    public UnsupportedFormatException() {
        super(null, Responses.UNSUPPORTED_MEDIA_TYPE, QueryParam.class,
                "format", "xml");
    }

}
