package com.impinj.itemsense.client.coordinator.authentication;

import com.impinj.itemsense.client.coordinator.user.User;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jcombopi on 1/25/16.
 */
public class AuthenticationController {
    private WebTarget target;
    private RestApiHelper<Token> restApiHelper;

    public AuthenticationController(WebTarget target) {
        this.target = target;
        this.restApiHelper = new RestApiHelper<>(Token.class);
    }

    public Response getTokenAsResponse() {
        return this.restApiHelper.get("/authentication/v1/token", target);
    }

    public Response getTokenAsResponse(String username) {
        return this.restApiHelper.get("/authentication/v1/token/" + username, target);
    }

    public Response listTokensAsResponse(String username) {
        return this.restApiHelper.get(username, "/authentication/v1/listTokens", target);
    }

    public Response validateTokenAsResponse(Token token) {
        return this.restApiHelper.post(token, "/authentication/v1/validateToken", target);
    }

    public Response revokeTokenAsResponse(Token token) {
        return this.restApiHelper.put(token, "/authentication/v1/revokeToken", target);
    }

    public Response revokeTokensAsResponse(String username) {
        return this.restApiHelper.put("/authentication/v1/revokeTokens/" + username, target);
    }

    public Token getToken() {
        return this.getTokenAsResponse().readEntity(Token.class);
    }

    public Token getToken(String username) {
        return this.getTokenAsResponse(username).readEntity(Token.class);
    }

    public List<ListTokenResponse> listTokens(String username) {
        ListTokenResponse[] tokens = this.listTokensAsResponse(username).readEntity(ListTokenResponse[].class);
        return new ArrayList<ListTokenResponse>(Arrays.asList(tokens));
    }

    public User validateToken(Token token) {
        return this.validateTokenAsResponse(token).readEntity(User.class);
    }

    public void revokeToken(Token token) {
        Response response = revokeTokenAsResponse(token);
        response.close();
    }

    public void revokeTokens(String username) {
        Response response = revokeTokensAsResponse(username);
        response.close();
    }

}
