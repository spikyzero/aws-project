package com.serverless.service.impl;

import com.serverless.model.User;
import com.serverless.service.UserService;

public class DefaultUserService implements UserService {

    @Override
    public String getUserInfo(User user) {
        return "{User: name: " + user.getName() + "; email: " + user.getEmail() + "; age: " + user.getAge() + "}";
    }

    @Override
    public User createUser() {
        User user = new User();
        user.setName("Nick");
        user.setEmail("nick@mail.com");
        user.setAge(24);
        return user;
    }

}
