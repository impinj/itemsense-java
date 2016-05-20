package com.impinj.itemsense.client.coordinator;


import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMap;
import com.impinj.itemsense.client.coordinator.currentZoneMap.CurrentZoneMapController;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URI;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.instanceOf;


/**
 * Created by jcombopi on 1/29/16.
 */
public class CurrentZoneMapControllerTest {

    private CoordinatorApiController coordinatorApiController;
    private CurrentZoneMapController currentZoneMapController;
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
        currentZoneMapController = coordinatorApiController.getCurrentZoneMapController();
        gson = new Gson();

    }

    @After
    public void tearDown() throws Exception {

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

