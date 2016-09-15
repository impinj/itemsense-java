package com.impinj.itemsense.client.coordinator;


import com.google.gson.Gson;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMap;
import com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMapController;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.Client;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

public class CurrentZoneMapControllerTest {

    private CurrentZoneMapController currentZoneMapController;
    private Gson gson;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = TestUtils.getClient();

        currentZoneMapController =
                new CoordinatorApiController(client, TestUtils.MOCK_URI)
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

