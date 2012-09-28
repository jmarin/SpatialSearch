package org.geo.spatialsearch.util;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.geo.spatialsearch.census.model.CensusGeographyEnum;
import org.geo.spatialsearch.rest.APIResponse;
import org.springframework.util.StringUtils;

public final class ValidationUtil {

    public static boolean isValidCensusGeographyType(APIResponse apiResponse,
            CensusGeographyEnum geographyType) {
        if (!StringUtils.hasLength(geographyType.toString())) {
            apiResponse.getMessageList().add(
                    Message.GEOGRAPHY_TYPE_NOT_VALID.getMessage());
            apiResponse.setStatus(Status.BAD_REQUEST.getReasonPhrase());
            return false;
        }
        return true;
    }

    public static boolean isEmptyResult(APIResponse apiResponse, List<?> results) {
        if (results.isEmpty()) {
            String message = new StringBuffer().append(
                    Message.NO_RESULTS_FOUND.getMessage()).toString();
            apiResponse.getMessageList().add(message);
            return true;
        }
        return false;
    }

    public static boolean isEmptyResult(APIResponse apiResponse,
            List<?> results, Message message, Status status) {
        if (results.isEmpty()) {
            apiResponse.getMessageList().add(message.getMessage());
            if (status != null) {
                apiResponse.setStatus(status.getReasonPhrase());
            }
            return true;
        }
        return false;
    }

    public static boolean isEmptyResult(APIResponse apiResponse, Object result,
            Message message, Status status) {
        if (result == null) {
            apiResponse.getMessageList().add(message.getMessage());
            if (status != null) {
                apiResponse.setStatus(status.getReasonPhrase());
            }
            return true;
        }
        return false;
    }

}
