package com.impinj.itemHistorysense.client.data;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.data.DataApiController;
import com.impinj.itemsense.client.data.itemhistory.ItemHistory;
import com.impinj.itemsense.client.data.itemhistory.ItemHistoryController;
import com.impinj.itemsense.client.data.itemhistory.ItemHistoryResponse;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URI;
import java.util.ArrayList;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by jcombopi on 2/1/16.
 */
public class ItemHistoryControllerTest {

    private DataApiController dataApiController;
    private ItemHistoryController itemHistoryController;
    private Gson gson;
    private String itemHistoryResponseTestString;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(8089);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = ClientBuilder.newClient().register(HttpAuthenticationFeature.basic("testUser", "testPassword"));

        //http://localhost:8089 is where wiremock is running
        dataApiController = new DataApiController(client, URI.create("http://localhost:8089"));
        itemHistoryController = dataApiController.getItemHistoryController();
        gson = new Gson();
        itemHistoryResponseTestString ="{\n" +
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
    public void GetItemHistorysTest(){

        stubFor(get(urlEqualTo("/data/v1/items/show/history")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(itemHistoryResponseTestString)));

        ItemHistoryResponse itemHistoryResponse = itemHistoryController.getItemHistory();

        Assert.assertNotNull(itemHistoryResponse );
        Assert.assertNotNull(itemHistoryResponse.getHistory());
        Assert.assertThat(itemHistoryResponse.getHistory()[0], instanceOf(ItemHistory.class));

    }

    @Test
    public void GetAllItemHistorysTest(){
        stubFor(get(urlEqualTo("/data/v1/items/show/history?pageSize=1000")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(itemHistoryResponseTestString)));

        ArrayList<ItemHistory> itemHistorys = itemHistoryController.getAllItemHistory();

        Assert.assertNotNull(itemHistorys);
        Assert.assertThat(itemHistorys, instanceOf(ArrayList.class));
        Assert.assertThat(itemHistorys.get(0), instanceOf(ItemHistory.class));

    }


}
