package com.impinj.itemsense.client.coordinator;


import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.authentication.AuthenticationController;
import com.impinj.itemsense.client.coordinator.authentication.ListTokenResponse;
import com.impinj.itemsense.client.coordinator.authentication.Token;
import com.impinj.itemsense.client.coordinator.user.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

public class AuthenticationControllerTest {
    private CoordinatorApiController coordinatorApiController;
    private AuthenticationController authenticationController;
    private String listTokenTestString;
    private String validateTokenTestString;
    private String getTokenTestString;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;

    @Before
    public void setUp() throws Exception {
        Client client = TestUtils.getClient();

        coordinatorApiController = new CoordinatorApiController(client, TestUtils.MOCK_URI);
        authenticationController = coordinatorApiController.getAuthenticationController();
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
    public void validateTokenTest() {
        String expectedUserString = "{\"name\":\"Test_User\",\"roles\":[\"Admin\",\"Job_Runner\"]}";
        stubFor(post(urlEqualTo("/authentication/v1/validateToken")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(expectedUserString)));

        Token token = new Token("c84c838a-9388-4896-a678-8cbae93c407a");
        Response response = authenticationController.validateTokenAsResponse(token);
        Assert.assertEquals(200, response.getStatus());
        response.close();

        User user = authenticationController.validateToken(token);

        Assert.assertNotNull(user);
        Assert.assertThat(user, instanceOf(User.class));
        Assert.assertEquals("Test_User", user.getName());
        Assert.assertEquals(2, user.getRoles().length);
        Assert.assertEquals("Admin", user.getRoles()[0]);
        Assert.assertEquals("Job_Runner", user.getRoles()[1]);
    }

    @Test
    public void revokeTokenTest() {
        stubFor(put(urlEqualTo("/authentication/v1/revokeToken")).willReturn(aResponse()
            .withStatus(204)
            .withHeader("Content-Type", "application/json")
            .withBody(getTokenTestString)));

        Token tokenToRevoke = new Token();
        tokenToRevoke.setToken("c84c838a-9388-4896-a678-8cbae93c407a");
        Response response = authenticationController.revokeTokenAsResponse(tokenToRevoke);
        Assert.assertEquals(204, response.getStatus());
        response.close();
    }

    @Test
    public void revokeTokensTest() {
        stubFor(put(urlEqualTo("/authentication/v1/revokeTokens/Admin")).willReturn(aResponse()
            .withStatus(204)
            .withHeader("Content-Type", "application/json")
            .withBody("")));


        Response response = authenticationController.revokeTokensAsResponse("Admin");
        Assert.assertEquals(204, response.getStatus());
        response.close();
    }

    @Test
    public void listTokensTest() throws Exception {
        stubFor(get(urlEqualTo("/authentication/v1/listTokens/Admin")).willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody(listTokenTestString)));

        Response response = authenticationController.listTokensAsResponse("Admin");
        Assert.assertEquals(200, response.getStatus());
        response.close();

        List<ListTokenResponse> tokens = authenticationController.listTokens("Admin");
        Assert.assertNotNull(tokens);
        Assert.assertThat(tokens, instanceOf(ArrayList.class));
        Assert.assertThat(tokens.get(0), instanceOf(ListTokenResponse.class));

    }

}
