package com.impinj.itemsense.client.coordinator.user;


import com.impinj.itemsense.client.helpers.RestApiHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


public class UserController {

    private WebTarget target;
    private RestApiHelper<User> restApiHelper;

    public UserController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<User>(User.class);
    }

    public Response createUserAsResponse(User user) {
        return this.restApiHelper.post(user, "/configuration/v1/users/create", target);
    }

    public Response updateUserAsResponse(User user) {
        return this.restApiHelper.put(user, "/configuration/v1/users/create", target);
    }

    public Response getUserAsResponse(String userName) {
        return this.restApiHelper.get(userName, "/configuration/v1/users/show", target);
    }

    public Response getUsersAsResponse() {
        return this.restApiHelper.get("/configuration/v1/users/show", target);
    }

    public Response deleteUser(String userName) {
        return this.restApiHelper.delete(userName, "/configuration/v1/users/destroy", target);
    }

    public User createUser(User user) {
        return this.createUserAsResponse(user).readEntity(User.class);
    }

    public User updateUser(User user) {
        return this.updateUserAsResponse(user).readEntity(User.class);
    }

    public User getUser(String userName) {
        return this.getUserAsResponse(userName).readEntity(User.class);
    }

    public List<User> getUsers() {
        User[] users = this.getUsersAsResponse().readEntity(User[].class);
        return new ArrayList<User>(Arrays.asList(users));
    }

}
