package com.impinj.itemsense.client.coordinator;



import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.coordinator.zonemap.Point;
import com.impinj.itemsense.client.coordinator.zonemap.Zone;
import com.impinj.itemsense.client.coordinator.zonemap.ZoneMap;
import com.impinj.itemsense.client.coordinator.zonemap.ZoneMapController;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.instanceOf;




public class ZoneMapControllerTest {

    private CoordinatorApiController coordinatorApiController;
    private ZoneMapController zoneMapController;
    private Gson gson;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic("testZoneMap", "testPassword"));

        //http://localhost:8089 is where wiremock is running
        coordinatorApiController = new CoordinatorApiController(client, URI.create("http://localhost:8089"));
        zoneMapController = coordinatorApiController.getZoneMapController();
        gson = new Gson();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void GetZoneMapsTest(){
        Zone testZone = new Zone("First_Floor", "1", new Point[] {new Point(0,0, 0), new Point(10, 10, 0), new Point(0, 10, 0), new Point(10, 0, 0)});
        ZoneMap testZoneMap = new ZoneMap("Test_Zone_Map", "Test_Facility", new Zone[]{testZone});
        ArrayList<ZoneMap> testZoneMaps = new ArrayList<>();
        testZoneMaps.add(testZoneMap);

        stubFor(get(urlEqualTo("/configuration/v1/zoneMaps/show")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testZoneMaps))));

        List<ZoneMap> zoneMaps = zoneMapController.getZoneMaps();

        Assert.assertEquals(zoneMaps.size(), 1);
        Assert.assertThat(zoneMaps, instanceOf(ArrayList.class));
        Assert.assertThat(zoneMaps.get(0), instanceOf(ZoneMap.class));
        Assert.assertEquals(zoneMaps.get(0),testZoneMap);
        Assert.assertThat(zoneMaps.get(0).getZones()[0], instanceOf(Zone.class));
        Assert.assertEquals(zoneMaps.get(0).getZones()[0], testZone);
    }

    @Test
    public void GetZoneMapTest(){
        Zone testZone = new Zone("First_Floor", "1", new Point[] {new Point(0,0, 0), new Point(10, 10, 0), new Point(0, 10, 0), new Point(10, 0, 0)});
        ZoneMap testZoneMap = new ZoneMap("Test_Zone_Map", "Test_Facility", new Zone[]{testZone});

        stubFor(get(urlEqualTo("/configuration/v1/zoneMaps/show/Test_Zone_Map")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testZoneMap))));

        ZoneMap zoneMapResult =  zoneMapController.getZoneMap("Test_Zone_Map");
        Assert.assertEquals(zoneMapResult, testZoneMap);
        Assert.assertThat(zoneMapResult, instanceOf(ZoneMap.class));
        Assert.assertThat(zoneMapResult.getZones()[0], instanceOf(Zone.class));
        Assert.assertEquals(zoneMapResult.getZones()[0], testZone);

    }





}