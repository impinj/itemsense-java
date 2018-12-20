package com.impinj.itemsense.client.coordinator;


import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.zonemap.Point;
import com.impinj.itemsense.client.coordinator.zonemap.Zone;
import com.impinj.itemsense.client.coordinator.zonemap.ZoneMap;
import com.impinj.itemsense.client.coordinator.zonemap.ZoneMapController;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;


public class ZoneMapControllerTest {

  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private CoordinatorApiController coordinatorApiController;
  private ZoneMapController zoneMapController;
  private Gson gson;

  @Before
  public void setUp() throws Exception {

    Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature
                                                           .basic("testZoneMap", "testPassword"));

    coordinatorApiController = new CoordinatorApiController(client, TestUtils.MOCK_URI);
    zoneMapController = coordinatorApiController.getZoneMapController();
    gson = new Gson();

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void GetZoneMapsTest() {
    Zone testZone = new Zone(
        "First_Floor",
        "1",
        new Point[]{new Point(0, 0, 0), new Point(10, 10, 0), new Point(0, 10, 0),
            new Point(10, 0, 0)});
    ZoneMap testZoneMap = new ZoneMap("Test_Zone_Map", "Test_Facility", new Zone[]{testZone});
    ArrayList<ZoneMap> testZoneMaps = new ArrayList<>();
    testZoneMaps.add(testZoneMap);

    stubFor(get(urlEqualTo("/configuration/v1/zoneMaps/show")).willReturn(aResponse()
                                                                              .withStatus(200)
                                                                              .withHeader(
                                                                                  "Content-Type",
                                                                                  "application/json")
                                                                              .withBody(gson.toJson(
                                                                                  testZoneMaps))));

    List<ZoneMap> zoneMaps = zoneMapController.getZoneMaps();

    Assert.assertEquals(zoneMaps.size(), 1);
    Assert.assertThat(zoneMaps, instanceOf(ArrayList.class));
    Assert.assertThat(zoneMaps.get(0), instanceOf(ZoneMap.class));
    Assert.assertEquals(zoneMaps.get(0), testZoneMap);
    Assert.assertThat(zoneMaps.get(0).getZones()[0], instanceOf(Zone.class));
    Assert.assertEquals(zoneMaps.get(0).getZones()[0], testZone);
  }

  @Test
  public void GetZoneMapTest() {
    Zone testZone = new Zone(
        "First_Floor",
        "1",
        new Point[]{new Point(0, 0, 0), new Point(10, 10, 0), new Point(0, 10, 0),
            new Point(10, 0, 0)});
    ZoneMap testZoneMap = new ZoneMap("Test_Zone_Map", "Test_Facility", new Zone[]{testZone});

    stubFor(get(urlEqualTo("/configuration/v1/zoneMaps/show/Test_Zone_Map")).willReturn(aResponse()
                                                                                            .withStatus(
                                                                                                200)
                                                                                            .withHeader(
                                                                                                "Content-Type",
                                                                                                "application/json")
                                                                                            .withBody(
                                                                                                gson.toJson(
                                                                                                    testZoneMap))));

    ZoneMap zoneMapResult = zoneMapController.getZoneMap("Test_Zone_Map");
    Assert.assertEquals(zoneMapResult, testZoneMap);
    Assert.assertThat(zoneMapResult, instanceOf(ZoneMap.class));
    Assert.assertThat(zoneMapResult.getZones()[0], instanceOf(Zone.class));
    Assert.assertEquals(zoneMapResult.getZones()[0], testZone);

  }


}