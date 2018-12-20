package com.impinj.itemsense.client.data;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.data.itemhistory.ItemHistory;
import com.impinj.itemsense.client.data.itemhistory.ItemHistoryController;
import com.impinj.itemsense.client.data.itemhistory.ItemHistoryResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;


public class ItemHistoryControllerTest {

  private static final Map<String, Object> EMPTY_QUERY_PARAMS = new HashMap<>();
  private static final int PAGE_SIZE = 1000;
  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private DataApiController dataApiController;
  private ItemHistoryController itemHistoryController;
  private String itemHistoryResponseTestString;

  @Before
  public void setUp() throws Exception {

    Client client = TestUtils.getClient();

    dataApiController = new DataApiController(client, TestUtils.MOCK_URI);
    itemHistoryController = dataApiController.getItemHistoryController();
    itemHistoryResponseTestString = "{\n" +
        "  \"history\": [\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CA6547\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CABB57\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CA6537\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CA21B7\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CA65A7\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CA65B7\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CADD07\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CA9157\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497C9F507\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CA6547\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497C9DBC6\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CA6537\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CA21B7\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"epc\": \"E28011606000020497CA65A7\",\n" +
        "      \"tagId\": \"000000000000\",\n" +
        "      \"fromZone\": \"FACILITY\",\n" +
        "      \"toZone\": \"Bryan_Office\",\n" +
        "      \"fromFacility\": \"DEFAULT\",\n" +
        "      \"toFacility\": \"DEFAULT\",\n" +
        "      \"observationTime\": \"2015-11-03T18:05:14Z\"\n" +
        "    }" +
        "  ],\n" +
        "  \"nextPageMarker\": null\n" +
        "}";

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetItemHistory() {

    stubFor(get(urlEqualTo("/data/v1/items/show/history")).willReturn(aResponse()
                                                                          .withStatus(200)
                                                                          .withHeader(
                                                                              "Content-Type",
                                                                              "application/json")
                                                                          .withBody(
                                                                              itemHistoryResponseTestString)));

    ItemHistoryResponse itemHistoryResponse = itemHistoryController.getItemHistory();

    Assert.assertNotNull(itemHistoryResponse);
    Assert.assertNotNull(itemHistoryResponse.getHistory());
    Assert.assertThat(itemHistoryResponse.getHistory()[0], instanceOf(ItemHistory.class));

  }

  @Test
  public void testGetItemHistoryEmptyResponse() {
    String emptyResponse = "{\"history\":[],\"nextPageMarker\":null,\"moreHistoryAvailable\":false}";

    stubFor(get(urlEqualTo("/data/v1/items/show/history")).willReturn(aResponse()
                                                                          .withStatus(200)
                                                                          .withHeader(
                                                                              "Content-Type",
                                                                              "application/json")
                                                                          .withBody(emptyResponse)));

    Response response = itemHistoryController.getItemHistoryAsResponse(EMPTY_QUERY_PARAMS);
    Assert.assertEquals(200, response.getStatus());
    ItemHistoryResponse itemHistoryResponse = response.readEntity(ItemHistoryResponse.class);
    response.close();

    Assert.assertEquals(0, itemHistoryResponse.getHistory().length);
    Assert.assertEquals(null, itemHistoryResponse.getNextPageMarker());
    Assert.assertEquals(false, itemHistoryResponse.isMoreHistoryAvailable());
  }

  @Test
  public void testGetItemHistorySingleResponse() {
    String singleResponse = "{\"history\":[{\"epc\":\"E280116060000205077DA2BF\",\"tagId\":\"000000000000\",\"fromZone\":\"ABSENT\",\"fromFloor\":null,\"toZone\":\"FACILITY\",\"toFloor\":null,\"fromFacility\":null,\"toFacility\":\"NEWFAC\",\"fromX\":null,\"fromY\":null,\"toX\":0.0,\"toY\":6.5,\"observationTime\":\"2016-07-20T17:41:28Z\"}],\"nextPageMarker\":\"HYqwnIZCy7VZum+imjU/4pHawLBHymFsecje7nGZ5ZY=\",\"moreHistoryAvailable\":true}";

    stubFor(get(urlEqualTo("/data/v1/items/show/history")).willReturn(aResponse()
                                                                          .withStatus(200)
                                                                          .withHeader(
                                                                              "Content-Type",
                                                                              "application/json")
                                                                          .withBody(singleResponse)));

    Response response = itemHistoryController.getItemHistoryAsResponse(EMPTY_QUERY_PARAMS);
    Assert.assertEquals(200, response.getStatus());
    ItemHistoryResponse itemHistoryResponse = response.readEntity(ItemHistoryResponse.class);
    response.close();

    Assert.assertEquals(1, itemHistoryResponse.getHistory().length);
    Assert.assertEquals("E280116060000205077DA2BF", itemHistoryResponse.getHistory()[0].getEpc());
    Assert.assertEquals(
        "HYqwnIZCy7VZum+imjU/4pHawLBHymFsecje7nGZ5ZY=",
        itemHistoryResponse.getNextPageMarker());
    Assert.assertEquals(true, itemHistoryResponse.isMoreHistoryAvailable());
  }

  @Test
  public void getItemHistoryNextPage() {
    String nextPageResult = "{\"history\":[{\"epc\":\"E280116060000205077DA2BF\",\"tagId\":\"000000000000\",\"fromZone\":\"ABSENT\",\"fromFloor\":null,\"toZone\":\"FACILITY\",\"toFloor\":null,\"fromFacility\":null,\"toFacility\":\"NEWFAC\",\"fromX\":null,\"fromY\":null,\"toX\":0.0,\"toY\":6.5,\"observationTime\":\"2016-07-20T17:41:28Z\"}],\"nextPageMarker\":\"dhHSFz1upKy81uk7hrWLJFo+JckUtACqJRCzpEXVubs=\",\"moreHistoryAvailable\":true}\n";

    stubFor(get(urlEqualTo("/data/v1/items/show/history?page=2")).willReturn(aResponse()
                                                                                 .withStatus(200)
                                                                                 .withHeader(
                                                                                     "Content-Type",
                                                                                     "application/json")
                                                                                 .withBody(
                                                                                     nextPageResult)));

    Map<String, Object> queryParams = new HashMap<>();
    queryParams.put("page", 2);

    ItemHistoryResponse itemHistoryResponse = itemHistoryController.getItemHistory(queryParams);
    Assert.assertEquals(
        "dhHSFz1upKy81uk7hrWLJFo+JckUtACqJRCzpEXVubs=",
        itemHistoryResponse.getNextPageMarker());
  }

  @Test
  public void testGetAllItemHistoryWithEpcFormat() {
    String historyWithEpcFormat = "{\"history\":[{\"epc\":\"urn:epc:raw::96.E280116060000205077DA2BF\",\"tagId\":\"000000000000\",\"fromZone\":\"ABSENT\",\"fromFloor\":null,\"toZone\":\"FACILITY\",\"toFloor\":null,\"fromFacility\":null,\"toFacility\":\"NEWFAC\",\"fromX\":null,\"fromY\":null,\"toX\":0.0,\"toY\":6.5,\"observationTime\":\"2016-07-20T17:41:28Z\"},{\"epc\":\"urn:epc:raw::96.E280116060000205077DA26F\",\"tagId\":\"000000000000\",\"fromZone\":\"ABSENT\",\"fromFloor\":null,\"toZone\":\"FACILITY\",\"toFloor\":null,\"fromFacility\":null,\"toFacility\":\"NEWFAC\",\"fromX\":null,\"fromY\":null,\"toX\":0.0,\"toY\":6.5,\"observationTime\":\"2016-07-20T17:41:28Z\"},{\"epc\":\"urn:epc:raw::96.B0D1E5000000000000000004\",\"tagId\":\"000000000000\",\"fromZone\":\"ABSENT\",\"fromFloor\":null,\"toZone\":\"FACILITY\",\"toFloor\":null,\"fromFacility\":null,\"toFacility\":\"NEWFAC\",\"fromX\":null,\"fromY\":null,\"toX\":0.0,\"toY\":6.5,\"observationTime\":\"2016-07-20T17:41:28Z\"}],\"nextPageMarker\":null,\"moreHistoryAvailable\":true}";

    stubFor(get(urlEqualTo("/data/v1/items/show/history?pageSize=1000&epcFormat=RAW"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(historyWithEpcFormat)));

    List<ItemHistory> events = itemHistoryController.getAllItemHistory(EpcFormat.RAW);

    Assert.assertEquals(3, events.size());
    Assert.assertEquals("urn:epc:raw::96.E280116060000205077DA2BF", events.get(0).getEpc());
  }

  @Test
  public void testGetAllItemHistoryWithMultiplePages() {
    // Page size is fixed to the maximum in this interface, so simulate a string with 1001 items in it.
    String event = "{\"epc\":\"E280116060000205077DA2BF\",\"tagId\":\"000000000000\",\"fromZone\":\"ABSENT\",\"fromFloor\":null,\"toZone\":\"FACILITY\",\"toFloor\":null,\"fromFacility\":null,\"toFacility\":\"NEWFAC\",\"fromX\":null,\"fromY\":null,\"toX\":0.0,\"toY\":6.5,\"observationTime\":\"2016-07-20T17:41:28Z\"}";

    StringBuilder responseWith1000Items = new StringBuilder("{\"history\":[");
    for (int i = 0; i < PAGE_SIZE; i++) {
      String replacementString = "\"tagId\":\"00000000000" + i + "\"";
      String newEvent = event.replace("\"tagId\":\"000000000000\"", replacementString);
      responseWith1000Items.append(newEvent);
      responseWith1000Items.append(",");
    }
    responseWith1000Items.setCharAt(responseWith1000Items.length() - 1, ']');
    responseWith1000Items.append(
        ",\"nextPageMarker\":\"UD41zBHH76BqmMdukctbvJvdE9oXQAxPyh6Jw5BjojLdR1paQrVDHN6/hja1TGaR\"}\"");

    String lastResponse = "{\"history\":[{\"epc\":\"E280116060000205077DA2BF\",\"tagId\":\"000000000001000\",\"fromZone\":\"ABSENT\",\"fromFloor\":null,\"toZone\":\"FACILITY\",\"toFloor\":null,\"fromFacility\":null,\"toFacility\":\"NEWFAC\",\"fromX\":null,\"fromY\":null,\"toX\":0.0,\"toY\":6.5,\"observationTime\":\"2016-07-20T17:41:28Z\"}],\"nextPageMarker\":null, \"moreHistoryAvailable\":false}";

    stubFor(get(urlEqualTo("/data/v1/items/show/history?pageSize=1000")).willReturn(aResponse()
                                                                                        .withStatus(
                                                                                            200)
                                                                                        .withHeader(
                                                                                            "Content-Type",
                                                                                            "application/json")
                                                                                        .withBody(
                                                                                            responseWith1000Items
                                                                                                .toString())));

    stubFor(get(urlEqualTo(
        "/data/v1/items/show/history?pageMarker=UD41zBHH76BqmMdukctbvJvdE9oXQAxPyh6Jw5BjojLdR1paQrVDHN6%2Fhja1TGaR&pageSize=1000"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(lastResponse)));

    List<ItemHistory> items = itemHistoryController.getAllItemHistory();

    Assert.assertEquals(1001, items.size());

    for (int i = 0; i < 1001; i++) {
      Assert.assertEquals("00000000000" + i, items.get(i).getTagId());
    }
  }


  @Test
  public void testGetAllItemHistoryBasic() {
    stubFor(get(urlEqualTo("/data/v1/items/show/history?pageSize=1000")).willReturn(aResponse()
                                                                                        .withStatus(
                                                                                            200)
                                                                                        .withHeader(
                                                                                            "Content-Type",
                                                                                            "application/json")
                                                                                        .withBody(
                                                                                            itemHistoryResponseTestString)));

    ArrayList<ItemHistory> itemHistorys = itemHistoryController.getAllItemHistory();

    Assert.assertNotNull(itemHistorys);
    Assert.assertThat(itemHistorys, instanceOf(ArrayList.class));
    Assert.assertThat(itemHistorys.get(0), instanceOf(ItemHistory.class));
  }


}
