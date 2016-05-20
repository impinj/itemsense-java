package com.impinj.itemsense.client.coordinator;

/**
 * Created by jcombopi on 1/29/16.
 */

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.coordinator.user.User;
import com.impinj.itemsense.client.coordinator.user.UserController;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.instanceOf;



/**
 * Created by jcombopi on 1/27/16.
 */
public class UserControllerTest {

    private CoordinatorApiController coordinatorApiController;
    private UserController userController;
    private Gson gson;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic("testUser", "testPassword"));

        //http://localhost:8089 is where wiremock is running
        coordinatorApiController = new CoordinatorApiController(client, URI.create("http://localhost:8089"));
        userController = coordinatorApiController.getUserController();
        gson = new Gson();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void GetUsersTest(){
        User testUser = new User("Test_User", null, new String[]{"Admin", "Job_Runner"});
        ArrayList<User> testUsers = new ArrayList<>();
        testUsers.add(testUser);

        stubFor(get(urlEqualTo("/configuration/v1/users/show")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testUsers))));

        List<User> users = userController.getUsers();

        Assert.assertEquals(users.size(), 1);
        Assert.assertThat(users, instanceOf(ArrayList.class));
        Assert.assertThat(users.get(0), instanceOf(User.class));
        Assert.assertEquals(users.get(0),testUser);
    }

    @Test
    public void GetUserTest(){
        User testUser = new User("Test_User", null, new String[]{"Admin", "Job_Runner"});
        stubFor(get(urlEqualTo("/configuration/v1/users/show/Test_User")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testUser))));

        User userResult =  userController.getUser("Test_User");
        Assert.assertEquals(userResult, testUser);
        Assert.assertThat(userResult, instanceOf(User.class));

    }





}