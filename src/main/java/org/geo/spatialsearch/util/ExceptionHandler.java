package org.geo.spatialsearch.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.geo.spatialsearch.rest.APIResponse;

public class ExceptionHandler {

    public void handle(APIResponse apiResponse, Exception ex) {
        apiResponse.setStatus(Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
        List<String> messages = apiResponse.getMessageList();
        messages.add("An error has occured");
        StringBuffer buffer = new StringBuffer(
                "There is a possibility of an data or coding issue. ");
        buffer.append("So, please forward the below stack trace to the developer to look into it.\n\n");
        buffer.append(getStackTrace(ex));
        messages.add(buffer.toString());
    }

    public static String getStackTrace(Throwable aThrowable) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        return result.toString();
    }

}
