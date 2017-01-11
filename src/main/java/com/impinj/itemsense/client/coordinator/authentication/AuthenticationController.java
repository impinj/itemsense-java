package com.impinj.itemsense.client.coordinator.authentication;

import com.impinj.itemsense.client.coordinator.user.User;
import com.impinj.itemsense.client.helpers.RestApiHelper;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class AuthenticationController {
    private WebTarget target;

    public AuthenticationController(WebTarget target) {
        this.target = target;
    }

    public Response getTokenAsResponse() {
        return RestApiHelper.get(target, "/authentication/v1/token");
    }

    public Response getTokenAsResponse(String username) {
        return RestApiHelper.put(target, "/authentication/v1/token", username);
    }

    public Response listTokensAsResponse(String username) {
        return RestApiHelper.get(target, "/authentication/v1/listTokens", username);
    }

    public Response validateTokenAsResponse(Token token) {
        return RestApiHelper.post(token, target, "/authentication/v1/validateToken");
    }

    public Response revokeTokenAsResponse(Token token) {
        return RestApiHelper.put(token, target, "/authentication/v1/revokeToken");
    }

    public Response revokeTokensAsResponse(String username) {
        return RestApiHelper.put(target, "/authentication/v1/revokeTokens", username);
    }

    public Token getToken() {
        return this.getTokenAsResponse().readEntity(Token.class);
    }

    public Token getToken(String username) {
        return this.getTokenAsResponse(username).readEntity(Token.class);
    }

    public List<ListTokenResponse> listTokens(String username) {
        return listTokensAsResponse(username)
                .readEntity(new GenericType<List<ListTokenResponse>>() {});
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
