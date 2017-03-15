package com.impinj.itemsense.client.coordinator.user;


import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


public class UserController {

  private static final String BASE_PATH = "/configuration/v1/users";
  private WebTarget target;

  public UserController(WebTarget target) {
    this.target = target;
  }

  public Response createUserAsResponse(User user) {
    return RestApiHelper.post(user, target, BASE_PATH, "create");
  }

  public Response updateUserAsResponse(User user) {
    return RestApiHelper.put(user, target, BASE_PATH, "create");
  }

  public Response getUserAsResponse(String userName) {
    return RestApiHelper.get(target, BASE_PATH, "show", userName);
  }

  public Response getUsersAsResponse() {
    return RestApiHelper.get(target, BASE_PATH, "show");
  }

  public Response deleteUser(String userName) {
    return RestApiHelper.delete(target, BASE_PATH, "destroy", userName);
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
    return getUsersAsResponse().readEntity(new GenericType<List<User>>() {});
  }

}
