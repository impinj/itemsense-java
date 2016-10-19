package com.impinj.itemsense.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.dongliu.gson.GsonJava8TypeAdapterFactory;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public abstract class TestUtils {

    public static final int MOCK_PORT = 8089;
    public static final URI MOCK_URI = URI.create(String.format("http://localhost:%d", MOCK_PORT));

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory())
            .create();

    public static Gson getGson() {
        return GSON;
    }

    public static Client getClient() {
        return ClientBuilder.newClient()
                .register(HttpAuthenticationFeature.basic("testUser", "testPassword"));
    }
}
