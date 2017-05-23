package com.impinj.itemsense.client.data;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.data.itemthresholdtransition.ItemThresholdTransition;
import com.impinj.itemsense.client.data.itemthresholdtransition.ItemThresholdTransitionController;
import com.impinj.itemsense.client.data.itemthresholdtransition.ItemThresholdTransitionResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.client.Client;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

public class ItemThresholdTransitionControllerTest {

  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);

  @Rule
  public WireMockClassRule instanceRule = wireMockRule;

  private DataApiController dataApiController;
  private ItemThresholdTransitionController itemThresholdTransitionController;
  private String itemThresholdTransitionTestResponse;

  @Before
  public void setUp() throws Exception {
    Client client = TestUtils.getClient();
    dataApiController = new DataApiController(client, TestUtils.MOCK_URI);
    itemThresholdTransitionController = dataApiController.getItemThresholdTransitionController();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        getClass().getResourceAsStream("/data/ItemThresholdTransitionResponse.json"),
        "UTF-8"))) {
      itemThresholdTransitionTestResponse = reader.lines().collect(Collectors.joining("\n"));
    }
  }

  @Test
  public void testGetAllItemThresholdTransitions() {
    stubFor(get(urlEqualTo("/data/v1/items/show/transitions?pageSize=1000"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(itemThresholdTransitionTestResponse)));

    List<ItemThresholdTransition> transitions = itemThresholdTransitionController.getAllItemThresholdTransitions();
    assertNotNull(transitions);
    assertEquals(3, transitions.size());
    ItemThresholdTransition transition = transitions.stream()
        .filter(item -> item.getEpc().equals("E28011606000020497CA6547")).findAny().orElse(null);
    assertNotNull(transition);
    assertEquals(1, transition.getThresholdId());
    assertEquals("OUT", transition.getDestination());
    assertEquals(1.0D, transition.getConfidence(), .0001);
  }

  @Test
  public void testGetItemThresholdTransitionsResponse() {
    stubFor(get(urlEqualTo("/data/v1/items/show/transitions"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(itemThresholdTransitionTestResponse)));

    ItemThresholdTransitionResponse response = itemThresholdTransitionController
        .getItemThresholdTransitions(new HashMap<>());
    assertNotNull(response);
    assertFalse(response.isMoreHistoryAvailable());
    assertNull(response.getNextPageMarker());
    assertNotNull(response.getTransitions());
    ItemThresholdTransition[] transitions = response.getTransitions();
    assertNotNull(transitions);
    assertEquals(3, transitions.length);
    ItemThresholdTransition transition = Arrays.stream(transitions)
        .filter(item -> item.getEpc().equals("E28011606000020497CA6547")).findAny().orElse(null);
    assertNotNull(transition);
    assertEquals(1, transition.getThresholdId());
    assertEquals("OUT", transition.getDestination());
    assertEquals(1.0D, transition.getConfidence(), .0001);
  }

  @Test
  public void testGetItemThresholdTransitions() {
    stubFor(get(urlEqualTo(
        "/data/v1/items/show/transitions?pageSize=100&epcFormat=DEFAULT&epcPrefix=E2"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(itemThresholdTransitionTestResponse)));

    ItemThresholdTransitionResponse response = itemThresholdTransitionController.getItemThresholdTransitions(
        "E2", null, null, null, null, null, null, null, EpcFormat.DEFAULT, null, 100, null);
    assertNotNull(response);
    assertFalse(response.isMoreHistoryAvailable());
    assertNull(response.getNextPageMarker());
    assertNotNull(response.getTransitions());
    ItemThresholdTransition[] transitions = response.getTransitions();
    assertNotNull(transitions);
    assertEquals(3, transitions.length);
    ItemThresholdTransition transition = Arrays.stream(transitions)
        .filter(item -> item.getEpc().equals("E28011606000020497CA6547")).findAny().orElse(null);
    assertNotNull(transition);
    assertEquals(1, transition.getThresholdId());
    assertEquals("OUT", transition.getDestination());
    assertEquals(1.0D, transition.getConfidence(), .0001);
  }
}
