package com.serverless.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.ApiGatewayResponse;
import com.serverless.Handler;
import com.serverless.model.User;
import com.serverless.service.UserService;
import com.serverless.service.impl.DefaultUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Map;

public class UserHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(Handler.class);
    private static final UserService userService = new DefaultUserService();

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        LOG.info("received: {}", input);
        return ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setObjectBody(getUserInfo())
                .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                .build();
    }

    private String getUserInfo() {
        User user = userService.createUser();
        return userService.getUserInfo(user);
    }

}
