package at.goosefraba.aws.lambda.template;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Test the application.
 */
public class ApplicationTest {

    @Test
    public void testHandleRequest() throws Exception {

        Application app = new Application();

        InputStream lambdaRequest = mock(InputStream.class);
        ByteArrayOutputStream lambdaResponse = new ByteArrayOutputStream();
        Context context = mock(Context.class);

        app.handleRequest(lambdaRequest, lambdaResponse, context);

        byte[] byteArray = lambdaResponse.toByteArray();
        assertEquals(
            "{\"headers\":{\"Content-Type\":\"application/json\"},\"body\":\"{\\\"status\\\":\\\"ok\\\"}\",\"statusCode\":\"200\"}",
            new String(byteArray)
        );
    }
}
