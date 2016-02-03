package com.impinj.itemsense.client.data;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.impinj.itemsense.client.data.item.ItemController;
import com.impinj.itemsense.client.data.item.ItemResponse;
import com.impinj.itemsense.client.data.item.Item;
import com.impinj.itemsense.client.helpers.ZonedDateTimeSerialization;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by jcombopi on 2/1/16.
 */
public class ItemControllerTest {

    private DataApiController dataApiController;
    private ItemController itemController;
    private Gson gson;
    private ItemResponse itemResponseTest;
    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic("testUser", "testPassword"));

        //http://localhost:8089 is where wiremock is running
        dataApiController = new DataApiController(client, URI.create("http://localhost:8089"));
        itemController = dataApiController.getItemController();
        gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeSerialization()).create();
        Item item = gson.fromJson("{\"epc\":\"30140008782B0AC000000001\",\"tagId\":\"000000000000\",\"xLocation\":-0.4,\"yLocation\":-0.3,\"zLocation\":0,\"zone\":\"Bryan_Office\",\"facility\":null,\"presenceConfidence\":\"HIGH\",\"lastModifiedTime\":\"2016-02-01T19:53:39Z\"}", Item.class);
        itemResponseTest = new ItemResponse(new Item[]{item}, null);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void GetItemsTest(){

        stubFor(get(urlEqualTo("/data/v1/items/show")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(itemResponseTest))));
        ItemResponse itemResponse = itemController.getItems();

        Assert.assertNotNull(itemResponse );
        Assert.assertNotNull(itemResponse.getItems());
        Assert.assertThat(itemResponse.getItems()[0], instanceOf(Item.class));

    }

    @Test
    public void GetAllItemsTest(){
        stubFor(get(urlEqualTo("/data/v1/items/show?pageSize=1000")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(itemResponseTest))));

        ArrayList<Item> items = itemController.getAllItems();

        Assert.assertNotNull(items);
        Assert.assertThat(items, instanceOf(ArrayList.class));
        Assert.assertThat(items.get(0), instanceOf(Item.class));

    }


}
