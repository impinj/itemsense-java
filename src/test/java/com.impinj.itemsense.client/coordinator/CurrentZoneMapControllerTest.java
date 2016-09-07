package com.impinj.itemsense.client.coordinator;


import com.google.gson.Gson;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMap;
import com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMapController;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

public class CurrentZoneMapControllerTest {

    private CurrentZoneMapController currentZoneMapController;
    private Gson gson;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = ClientBuilder.newClient()
                .register(HttpAuthenticationFeature.basic("testUser", "testPassword"));

        //http://localhost:8089 is where wiremock is running
        currentZoneMapController =
                new CoordinatorApiController(client, URI.create("http://localhost:8089"))
                        .getCurrentZoneMapController();
        gson = new Gson();

    }

    @Test
    public void GetDefaultCurrentZoneMap() {
        CurrentZoneMap defaultTest = new CurrentZoneMap("DEFAULT", "COMPLETE");
        stubFor(get(urlEqualTo("/configuration/v1/currentZoneMap/show")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(defaultTest))));

        CurrentZoneMap currentZoneMap = currentZoneMapController.getCurrentZoneMap();

        Assert.assertThat(currentZoneMap, instanceOf(CurrentZoneMap.class));
        Assert.assertEquals(currentZoneMap, defaultTest);
    }

    @Test
    public void GetCurrentZoneMapForFacility() {
        CurrentZoneMap seattleTest = new CurrentZoneMap("Seattle", "COMPLETE");
        stubFor(get(urlEqualTo("/configuration/v1/currentZoneMap/show/Seattle")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(seattleTest))));


        CurrentZoneMap currentZoneMap = currentZoneMapController.getCurrentZoneMap("Seattle");

        Assert.assertThat(currentZoneMap, instanceOf(CurrentZoneMap.class));
        Assert.assertEquals(currentZoneMap, seattleTest);
    }
}

