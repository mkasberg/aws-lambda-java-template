package at.goosefraba.aws.lambda.template;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Copyright goosefraba.at
 * Created by goosefraba on 27/10/2016.
 */
public class Application implements RequestStreamHandler {

    /**
     * The main entry point for our application.
     *
     * Read the docs!
     * http://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-create-api-as-simple-proxy-for-lambda.html#api-gateway-proxy-integration-lambda-function-java
     *
     * @param inputStream Input to the AWS Lambda function (forwarded by API Gateway).
     * @param outputStream Output. Should be JSON with a "statusCode" and "body" element. Optionally, include a
     *                    "headers" element as well.
     * @param context The application context.
     * @throws IOException When there's a problem reading/writing the stream.
     */
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        JSONObject responseJson = new JSONObject();

        // Body
        JSONObject responseBody = new JSONObject();
        responseBody.put("status", "ok");

        // Headers
        JSONObject headerJson = new JSONObject();
        headerJson.put("Content-Type", "application/json");

        // Assemble the response.
        responseJson.put("statusCode", "200");
        responseJson.put("body", responseBody.toString());
        responseJson.put("headers", headerJson);

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }
}
