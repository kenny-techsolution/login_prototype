package com.dovesquare.social;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import com.dovesquare.domain.User;
import com.dovesquare.service.UserService;

public class UserConnectionSignUp implements ConnectionSignUp {

    private final UserService userService;

    public UserConnectionSignUp(UserService userService) {
        this.userService = userService;
    }

    public String execute(Connection<?> connection) {
        UserProfile profile = connection.fetchUserProfile();
        User user = new User(profile.getUsername());
        userService.create(user);
        return user.getUsername();
    }

}