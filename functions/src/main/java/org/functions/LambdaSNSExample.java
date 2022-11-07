package org.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;

import java.net.HttpURLConnection;
import java.util.List;

import org.functions.model.Response;

public class LambdaSNSExample implements RequestHandler<SNSEvent, Response>{


    @Override
    public Response handleRequest(SNSEvent snsEvent, Context context) {
        LambdaLogger logger = context.getLogger();
        List<SNSEvent.SNSRecord> snsRecords = snsEvent.getRecords();
        snsRecords.forEach(v -> logger.log(v.getSNS().getMessage()));
        Response response=new Response();
        response.setMessage("OK Good Working");
        response.setHttpCode(200);
        return response;
    }
}