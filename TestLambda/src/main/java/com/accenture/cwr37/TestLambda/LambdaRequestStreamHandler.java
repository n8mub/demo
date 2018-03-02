package com.accenture.cwr37.TestLambda;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class LambdaRequestStreamHandler implements RequestStreamHandler {

	public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) {
		try {
			String input = IOUtils.toString(inputStream, "UTF-8");
			outputStream.write(("Hello World - " + input).getBytes());
		} catch (IOException e) {
			context.getLogger().log(e.getStackTrace().toString());
		}
	}

}
