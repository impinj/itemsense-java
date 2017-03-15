package com.impinj.itemsense.client.data;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.data.item.Item;
import com.impinj.itemsense.client.data.item.ItemController;
import com.impinj.itemsense.client.data.item.ItemResponse;
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


public class ItemControllerTest {

  private static final int PAGE_SIZE = 1000;
  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private DataApiController dataApiController;
  private ItemController itemController;
  private ItemResponse itemResponseTest;
  private Gson gson = TestUtils.getGson();

  @Before
  public void setUp() throws Exception {
    Client client = TestUtils.getClient();

    dataApiController = new DataApiController(client, TestUtils.MOCK_URI);
    itemController = dataApiController.getItemController();
    Item item = gson.fromJson(
        "{\"epc\":\"30140008782B0AC000000001\",\"tagId\":\"000000000000\",\"xLocation\":-0.4,\"yLocation\":-0.3,\"zLocation\":0,\"zone\":\"Bryan_Office\",\"facility\":null,\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-02-01T19:53:39Z\"}",
        Item.class);
    itemResponseTest = new ItemResponse(new Item[]{item}, null);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetItemsNoItemsTest() {
    String emptyResponse = "{\"items\":[],\"nextPageMarker\":null}";

    stubFor(get(urlEqualTo("/data/v1/items/show")).willReturn(aResponse()
                                                                  .withStatus(200)
                                                                  .withHeader(
                                                                      "Content-Type",
                                                                      "application/json")
                                                                  .withBody(emptyResponse)));

    Response response = itemController.getItemsAsResponse(null);
    Assert.assertEquals(200, response.getStatus());
    response.close();

    ItemResponse itemResponse = itemController.getItems();
    Assert.assertEquals(0, itemResponse.getItems().length);
    Assert.assertEquals(null, itemResponse.getNextPageMarker());
  }

  @Test
  public void testGetItemsOneResult() {
    String oneItemResponse = "{\"items\":[{\"epc\":\"3054337278081F2CA102DB28\",\"tagId\":\"000000000000\",\"xLocation\":-2.9,\"yLocation\":-1.5,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"facility\":\"NEWFAC\",\"presenceConfidence\":\"ILLEGAL VALUE\",\"lastModifiedTime\":\"2016-07-20T17:41:37Z\"}],\"nextPageMarker\":null}";

    stubFor(get(urlEqualTo("/data/v1/items/show")).willReturn(aResponse()
                                                                  .withStatus(200)
                                                                  .withHeader(
                                                                      "Content-Type",
                                                                      "application/json")
                                                                  .withBody(oneItemResponse)));

    Response response = itemController.getItemsAsResponse(null);
    Assert.assertEquals(200, response.getStatus());
    response.close();

    ItemResponse itemResponse = itemController.getItems();
    Assert.assertEquals(1, itemResponse.getItems().length);
    Item item = itemResponse.getItems()[0];
    Assert.assertNotNull(item);
    Assert.assertEquals("3054337278081F2CA102DB28", item.getEpc());
    Assert.assertNull(item.getPresenceConfidence());

    Assert.assertNull(itemResponse.getNextPageMarker());
  }

  @Test
  public void testGetItemsWithPageMarker() {
    String twoItemResponseWithPageMarker = "{\"items\":[{\"epc\":\"300833B2DDD9014000000000\",\"tagId\":\"000000000000\",\"xLocation\":-0.7,\"yLocation\":2.0,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"floor\":null,\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:32Z\"},{\"epc\":\"3054337278081F2CA102DB28\",\"tagId\":\"000000000000\",\"xLocation\":-2.9,\"yLocation\":-1.5,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"floor\":null,\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:37Z\"}],\"nextPageMarker\":\"UD41zBHH76BqmMdukctbvJvdE9oXQAxPyh6Jw5BjojLdR1paQrVDHN6/hja1TGaR\"}";

    stubFor(get(urlEqualTo("/data/v1/items/show")).willReturn(aResponse()
                                                                  .withStatus(200)
                                                                  .withHeader(
                                                                      "Content-Type",
                                                                      "application/json")
                                                                  .withBody(
                                                                      twoItemResponseWithPageMarker)));

    Response response = itemController.getItemsAsResponse(null);
    Assert.assertEquals(200, response.getStatus());
    response.close();

    ItemResponse itemResponse = itemController.getItems();
    Assert.assertEquals(2, itemResponse.getItems().length);
    Item item = itemResponse.getItems()[0];
    Assert.assertNotNull(item);
    Assert.assertEquals("300833B2DDD9014000000000", item.getEpc());

    item = itemResponse.getItems()[1];
    Assert.assertNotNull(item);
    Assert.assertEquals("3054337278081F2CA102DB28", item.getEpc());

    Assert.assertNotNull(itemResponse.getNextPageMarker());
  }

  @Test
  public void testGetItemsWithQueryParams() {
    String threeItemResponse = "{\"items\":[{\"epc\":\"urn:epc:id:sgtin:0867360217.005.0\",\"tagId\":\"000000000000\",\"xLocation\":-0.7,\"yLocation\":2.0,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"floor\":null,\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:32Z\"},{\"epc\":\"urn:epc:id:sgtin:0842910.008316.191679879976\",\"tagId\":\"000000000000\",\"xLocation\":-2.9,\"yLocation\":-1.5,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"floor\":null,\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:37Z\"},{\"epc\":\"urn:epc:id:sgtin:7071315.043714.478660\",\"tagId\":\"000000000000\",\"xLocation\":-2.3,\"yLocation\":1.2,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"floor\":null,\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:36Z\"}],\"nextPageMarker\":null}";

    stubFor(get(urlEqualTo(
        "/data/v1/items/show?zoneNames=FACILITY&fromTime=2016-07-20T17%3A00%3A00Z&pageSize=3&presenceConfidence=HIGH&facility=NEWFAC&epcFormat=PURE_ID&toTime=2016-07-20T18%3A01%3A00Z&epcPrefix=30"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(threeItemResponse)));

    Map<String, Object> queryParams = new HashMap<>();
    queryParams.put("epcFormat", EpcFormat.PURE_ID);
    queryParams.put("epcPrefix", "30");
    queryParams.put("zoneNames", "FACILITY");
    queryParams.put("presenceConfidence", "HIGH");
    queryParams.put("facility", "NEWFAC");
    queryParams.put("pageSize", "3");
    queryParams.put("fromTime", "2016-07-20T17:00:00Z");
    queryParams.put("toTime", "2016-07-20T18:01:00Z");
    Response response = itemController.getItemsAsResponse(queryParams);
    Assert.assertEquals(200, response.getStatus());
    response.close();

    ItemResponse itemResponse = itemController.getItems(queryParams);
    Item[] items = itemResponse.getItems();
    Assert.assertEquals(3, items.length);

    itemResponse = itemController.getItems(
        EpcFormat.PURE_ID,
        "30",
        null,
        "FACILITY",
        PresenceConfidence.HIGH,
        "NEWFAC",
        3,
        null,
        "2016-07-20T17:00:00Z",
        "2016-07-20T18:01:00Z");
    items = itemResponse.getItems();
    Assert.assertEquals(3, items.length);
  }


  @Test
  public void testGetItemsBasic() {
    stubFor(get(urlEqualTo("/data/v1/items/show")).willReturn(aResponse()
                                                                  .withStatus(200)
                                                                  .withHeader(
                                                                      "Content-Type",
                                                                      "application/json")
                                                                  .withBody(gson.toJson(
                                                                      itemResponseTest))));
    ItemResponse itemResponse = itemController.getItems();

    Assert.assertNotNull(itemResponse);
    Assert.assertNotNull(itemResponse.getItems());
    Assert.assertThat(itemResponse.getItems()[0], instanceOf(Item.class));
  }

  @Test
  public void testGetAllItems() {
    stubFor(get(urlEqualTo("/data/v1/items/show?pageSize=1000")).willReturn(aResponse()
                                                                                .withStatus(200)
                                                                                .withHeader(
                                                                                    "Content-Type",
                                                                                    "application/json")
                                                                                .withBody(gson.toJson(
                                                                                    itemResponseTest))));

    ArrayList<Item> items = itemController.getAllItems();

    Assert.assertNotNull(items);
    Assert.assertThat(items, instanceOf(ArrayList.class));
    Assert.assertThat(items.get(0), instanceOf(Item.class));

    stubFor(get(urlEqualTo("/data/v1/items/show?epcFormat=PURE_ID")).willReturn(aResponse()
                                                                                    .withStatus(200)
                                                                                    .withHeader(
                                                                                        "Content-Type",
                                                                                        "application/json")
                                                                                    .withBody(gson.toJson(
                                                                                        itemResponseTest))));

    Map<String, Object> queryParams = new HashMap<>();
    queryParams.put("epcFormat", EpcFormat.PURE_ID);
    Response response = dataApiController.getItemController().getItemsAsResponse(queryParams);
    Assert.assertEquals(200, response.getStatus());

    ItemResponse itemResponse = response.readEntity(ItemResponse.class);
    response.close();

    items = itemController.getAllItems();

    Assert.assertNotNull(items);
    Assert.assertThat(items, instanceOf(ArrayList.class));
    Assert.assertThat(items.get(0), instanceOf(Item.class));
  }

  @Test
  public void testGetAllItemsOneResult() {
    String oneItemResponse = "{\"items\":[{\"epc\":\"3054337278081F2CA102DB28\",\"tagId\":\"000000000000\",\"xLocation\":-2.9,\"yLocation\":-1.5,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:37Z\"}],\"nextPageMarker\":null}";

    stubFor(get(urlEqualTo("/data/v1/items/show?pageSize=1000")).willReturn(aResponse()
                                                                                .withStatus(200)
                                                                                .withHeader(
                                                                                    "Content-Type",
                                                                                    "application/json")
                                                                                .withBody(
                                                                                    oneItemResponse)));

    List<Item> items = itemController.getAllItems();
    Assert.assertEquals(1, items.size());
    Item item = items.get(0);
    Assert.assertNotNull(item);
    Assert.assertEquals("3054337278081F2CA102DB28", item.getEpc());
  }

  @Test
  public void testGetAllItemsTwoResults() {
    String twoItemResponse = "{\"items\":[{\"epc\":\"300833B2DDD9014000000000\",\"tagId\":\"000000000000\",\"xLocation\":-0.7,\"yLocation\":2.0,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"floor\":null,\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:32Z\"},{\"epc\":\"3054337278081F2CA102DB28\",\"tagId\":\"000000000000\",\"xLocation\":-2.9,\"yLocation\":-1.5,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"floor\":null,\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:37Z\"}],\"nextPageMarker\":null}";

    stubFor(get(urlEqualTo("/data/v1/items/show?pageSize=1000")).willReturn(aResponse()
                                                                                .withStatus(200)
                                                                                .withHeader(
                                                                                    "Content-Type",
                                                                                    "application/json")
                                                                                .withBody(
                                                                                    twoItemResponse)));

    List<Item> items = itemController.getAllItems();
    Assert.assertEquals(2, items.size());
    Item item = items.get(0);
    Assert.assertNotNull(item);
    Assert.assertEquals("300833B2DDD9014000000000", item.getEpc());

    item = items.get(1);
    Assert.assertNotNull(item);
    Assert.assertEquals("3054337278081F2CA102DB28", item.getEpc());
  }

  @Test
  public void getAllItemsWithEpcFormat() {
    String threeItemResponse = "{\"items\":" +
        "[{\"epc\":\"urn:epc:tag:sgtin-96:0.0867360217.005.0\",\"tagId\":\"000000000000\",\"xLocation\":-0.7,\"yLocation\":2.0,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:32Z\"},"
        +
        "{\"epc\":\"urn:epc:tag:sgtin-96:2.0842910.008316.191679879976\",\"tagId\":\"000000000000\",\"xLocation\":-2.9,\"yLocation\":-1.5,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:37Z\"},"
        +
        "{\"epc\":\"urn:epc:tag:sgtin-96:7.7071315.043714.478660\",\"tagId\":\"000000000000\",\"xLocation\":-2.3,\"yLocation\":1.2,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:36Z\"}],"
        +
        "\"nextPageMarker\":null}";

    stubFor(get(urlEqualTo("/data/v1/items/show?pageSize=1000&epcFormat=TAG"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(threeItemResponse)));

    List<Item> items = itemController.getAllItems(EpcFormat.TAG);
    Assert.assertEquals(3, items.size());
    Item item = items.get(0);
    Assert.assertNotNull(item);
    Assert.assertEquals("urn:epc:tag:sgtin-96:0.0867360217.005.0", item.getEpc());

    item = items.get(1);
    Assert.assertNotNull(item);
    Assert.assertEquals("urn:epc:tag:sgtin-96:2.0842910.008316.191679879976", item.getEpc());

    item = items.get(2);
    Assert.assertNotNull(item);
    Assert.assertEquals("urn:epc:tag:sgtin-96:7.7071315.043714.478660", item.getEpc());
  }

  @Test
  public void getAllItemsWithMultiplePages() {

    // Page size is fixed to the maximum in this interface, so simulate a string with 1001 items in it.
    String item = "{\"epc\":\"E280113020000001EFD214E3\",\"tagId\":\"000000000000\",\"xLocation\":2.9,\"yLocation\":0.0,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:32Z\"}";

    StringBuilder responseWith1000Items = new StringBuilder("{\"items\":[");
    for (int i = 0; i < PAGE_SIZE; i++) {
      String replacementString = "\"tagId\":\"00000000000" + i + "\"";
      String newItem = item.replace("\"tagId\":\"000000000000\"", replacementString);
      responseWith1000Items.append(newItem);
      responseWith1000Items.append(",");
    }
    responseWith1000Items.setCharAt(responseWith1000Items.length() - 1, ']');
    responseWith1000Items.append(
        ",\"nextPageMarker\":\"UD41zBHH76BqmMdukctbvJvdE9oXQAxPyh6Jw5BjojLdR1paQrVDHN6/hja1TGaR\"}\"");

    String lastItem = "{\"items\":[{\"epc\":\"3054337278081F2CA102DB28\",\"tagId\":\"000000000001000\",\"xLocation\":-2.9,\"yLocation\":-1.5,\"zLocation\":0.0,\"zone\":\"FACILITY\",\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:37Z\"}],\"nextPageMarker\":null}";

    stubFor(get(urlEqualTo("/data/v1/items/show?pageSize=1000")).willReturn(aResponse()
                                                                                .withStatus(200)
                                                                                .withHeader(
                                                                                    "Content-Type",
                                                                                    "application/json")
                                                                                .withBody(
                                                                                    responseWith1000Items
                                                                                        .toString())));

    stubFor(get(urlEqualTo(
        "/data/v1/items/show?pageMarker=UD41zBHH76BqmMdukctbvJvdE9oXQAxPyh6Jw5BjojLdR1paQrVDHN6%2Fhja1TGaR&pageSize=1000"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(lastItem)));

    List<Item> items = itemController.getAllItems();

    for (int i = 0; i < 1001; i++) {
      Assert.assertEquals("00000000000" + i, items.get(i).getTagId());
    }
    Assert.assertEquals(1001, items.size());
  }

  @Test
  public void testGetAllItemsWithQueryParamsWithoutTimes() {
    String threeItemResponse = "{\"items\":" +
        "[{\"epc\":\"urn:epc:tag:sgtin-96:0.0867360217.005.0\",\"tagId\":\"000000000000\",\"xLocation\":-0.7,\"yLocation\":2.0,\"zLocation\":0.0,\"zone\":\"ZONE1\",\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:32Z\"},"
        +
        "{\"epc\":\"urn:epc:tag:sgtin-96:2.0842910.008316.191679879976\",\"tagId\":\"000000000000\",\"xLocation\":-2.9,\"yLocation\":-1.5,\"zLocation\":0.0,\"zone\":\"ZONE2\",\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:37Z\"},"
        +
        "{\"epc\":\"urn:epc:tag:sgtin-96:7.7071315.043714.478660\",\"tagId\":\"000000000000\",\"xLocation\":-2.3,\"yLocation\":1.2,\"zLocation\":0.0,\"zone\":\"ZONE1\",\"facility\":\"NEWFAC\",\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-07-20T17:41:36Z\"}],"
        +
        "\"nextPageMarker\":null}";

    stubFor(get(urlEqualTo(
        "/data/v1/items/show?zoneNames=ZONE1%2CZONE2&pageSize=1000&presenceConfidence=HIGH&facility=NEWFAC&epcFormat=TAG&epcPrefix=96"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(threeItemResponse)));

    List<Item> items = itemController.getAllItems(
        EpcFormat.TAG,
        "96",
        null,
        "ZONE1,ZONE2",
        PresenceConfidence.HIGH,
        "NEWFAC");
    Assert.assertEquals(3, items.size());


  }


}
