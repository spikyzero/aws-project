package com.serverless.service;

import com.serverless.model.User;

public interface UserService {

    String getUserInfo(User user);

    User createUser();

}
