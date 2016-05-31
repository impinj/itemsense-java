package com.impinj.itemsense.client.coordinator;

/**
 * Created by jcombopi on 5/31/16.
 */

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.coordinator.authentication.AuthenticationController;
import com.impinj.itemsense.client.coordinator.authentication.ListTokenResponse;
import com.impinj.itemsense.client.coordinator.authentication.Token;
import com.impinj.itemsense.client.coordinator.readerconfiguration.*;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderDefinition;
import com.impinj.itemsense.client.coordinator.user.User;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.instanceOf;


public class AuthenticationControllerTest {
    private CoordinatorApiController coordinatorApiController;
    private AuthenticationController authenticationController;
    private Gson gson;
    private String listTokenTestString;
    private String validateTokenTestString;
    private String getTokenTestString;
    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic("testUser", "testPassword"));

        //http://localhost:8089 is where wiremock is running
        coordinatorApiController = new CoordinatorApiController(client, URI.create("http://localhost:8089"));
        authenticationController = coordinatorApiController.getAuthenticationController();
        gson = new Gson();
        listTokenTestString = "[\n" +
                " {\n" +
                "   \"authenticationToken\": {\n" +
                "     \"token\": \"2d81db41-ca35-4580-b05a-3f9f97a9928e\"\n" +
                "   },\n" +
                "   \"issued\": \"2016-05-31T18:32:15.602Z\",\n" +
                "   \"username\": \"Admin\",\n" +
                "   \"lastUsed\": \"2016-05-31T18:33:05.285Z\",\n" +
                "   \"valid\": true\n" +
                " },\n" +
                " {\n" +
                "   \"authenticationToken\": {\n" +
                "     \"token\": \"6ebca8ed-62ef-41d3-a348-fc5009b6ad96\"\n" +
                "   },\n" +
                "   \"issued\": \"2016-05-31T18:30:45.960Z\",\n" +
                "   \"username\": \"Admin\",\n" +
                "   \"lastUsed\": \"2016-05-31T18:30:45.960Z\",\n" +
                "   \"valid\": true\n" +
                " }\n" +
                "]";
        validateTokenTestString = "{\n" +
                "  \"name\": \"Admin\",\n" +
                "  \"roles\": [\n" +
                "    \"Admin\"\n" +
                "  ]\n" +
                "}";
        getTokenTestString = "{\n" +
                "  \"token\": \"c84c838a-9388-4896-a678-8cbae93c407a\"\n" +
                "}";
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getTokenTest(){
        stubFor(get(urlEqualTo("/authentication/v1/token")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(getTokenTestString)));

        Token token = authenticationController.getToken();
        Assert.assertNotNull(token);
        Assert.assertThat(token, instanceOf(Token.class));
    }
    @Test
    public void validateTokenTest(){
        User testUser = new User("Test_User", null, new String[]{"Admin", "Job_Runner"});
        stubFor(post(urlEqualTo("/authentication/v1/validateToken")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testUser))));


        Token token = new Token("c84c838a-9388-4896-a678-8cbae93c407a");
        User user = authenticationController.validateToken(token);

        Assert.assertNotNull(user);
        Assert.assertThat(user, instanceOf(User.class));
    }

    @Test
    public void listTokensTest(){
        stubFor(get(urlEqualTo("/authentication/v1/listTokens/Admin")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(listTokenTestString)));

        List<ListTokenResponse> tokens = authenticationController.listTokens("Admin");

        Assert.assertNotNull(tokens);
        Assert.assertThat(tokens, instanceOf(ArrayList.class));
        Assert.assertThat(tokens.get(0), instanceOf(ListTokenResponse.class));


    }



}
