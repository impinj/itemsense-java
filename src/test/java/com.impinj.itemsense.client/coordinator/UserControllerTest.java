package com.impinj.itemsense.client.coordinator;


import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.user.User;
import com.impinj.itemsense.client.coordinator.user.UserController;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;


public class UserControllerTest {

  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private CoordinatorApiController coordinatorApiController;
  private UserController userController;
  private Gson gson;

  @Before
  public void setUp() throws Exception {

    Client client = TestUtils.getClient();

    coordinatorApiController = new CoordinatorApiController(client, TestUtils.MOCK_URI);
    userController = coordinatorApiController.getUserController();
    gson = new Gson();

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void GetUsersTest() {
    User testUser = new User("Test_User", null, new String[]{"Admin", "Job_Runner"});
    ArrayList<User> testUsers = new ArrayList<>();
    testUsers.add(testUser);

    stubFor(get(urlEqualTo("/configuration/v1/users/show")).willReturn(aResponse()
                                                                           .withStatus(200)
                                                                           .withHeader(
                                                                               "Content-Type",
                                                                               "application/json")
                                                                           .withBody(gson.toJson(
                                                                               testUsers))));

    List<User> users = userController.getUsers();

    Assert.assertEquals(users.size(), 1);
    Assert.assertThat(users, instanceOf(ArrayList.class));
    Assert.assertThat(users.get(0), instanceOf(User.class));
    Assert.assertEquals(users.get(0), testUser);
  }

  @Test
  public void GetUserTest() {
    User testUser = new User("Test_User", null, new String[]{"Admin", "Job_Runner"});
    stubFor(get(urlEqualTo("/configuration/v1/users/show/Test_User")).willReturn(aResponse()
                                                                                     .withStatus(200)
                                                                                     .withHeader(
                                                                                         "Content-Type",
                                                                                         "application/json")
                                                                                     .withBody(gson.toJson(
                                                                                         testUser))));

    User userResult = userController.getUser("Test_User");
    Assert.assertEquals(userResult, testUser);
    Assert.assertThat(userResult, instanceOf(User.class));

  }


}