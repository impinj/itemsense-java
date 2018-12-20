package com.impinj.itemsense.client.coordinator;


import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.facility.Facility;
import com.impinj.itemsense.client.coordinator.facility.FacilityController;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;


public class FacilityControllerTest {

  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private CoordinatorApiController coordinatorApiController;
  private FacilityController facilityController;
  private Gson gson;

  @Before
  public void setUp() throws Exception {

    Client client = TestUtils.getClient();

    coordinatorApiController = new CoordinatorApiController(client, TestUtils.MOCK_URI);
    facilityController = coordinatorApiController.getFacilityController();
    gson = new Gson();

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void GetAllFacilities() {
    Facility testFacility = new Facility("TestFacility");
    ArrayList<Facility> testFacilities = new ArrayList<>();
    testFacilities.add(testFacility);

    stubFor(get(urlEqualTo("/configuration/v1/facilities/show")).willReturn(aResponse()
                                                                                .withStatus(200)
                                                                                .withHeader(
                                                                                    "Content-Type",
                                                                                    "application/json")
                                                                                .withBody(gson.toJson(
                                                                                    testFacilities))));

    List<Facility> facilities = facilityController.getAllFacilities();

    Assert.assertEquals(facilities.size(), 1);
    Assert.assertThat(facilities, instanceOf(ArrayList.class));
    Assert.assertThat(facilities.get(0), instanceOf(Facility.class));
    Assert.assertEquals(facilities.get(0), testFacility);
  }

  @Test
  public void GetFacility() {
    Facility testFacility = new Facility("TestFacility");

    stubFor(get(urlEqualTo("/configuration/v1/facilities/show/TestFacility")).willReturn(aResponse()
                                                                                             .withStatus(
                                                                                                 200)
                                                                                             .withHeader(
                                                                                                 "Content-Type",
                                                                                                 "application/json")
                                                                                             .withBody(
                                                                                                 gson.toJson(
                                                                                                     testFacility))));

    Facility facilityResult = facilityController.getFacility("TestFacility");
    Assert.assertEquals(facilityResult, testFacility);
    Assert.assertThat(facilityResult, instanceOf(Facility.class));

  }


}