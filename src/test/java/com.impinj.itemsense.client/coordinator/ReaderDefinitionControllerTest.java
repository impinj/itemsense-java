package com.impinj.itemsense.client.coordinator;


import com.google.gson.Gson;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.readerdefintion.Placement;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderDefinition;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderDefinitionController;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderType;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;




public class ReaderDefinitionControllerTest {

    private CoordinatorApiController coordinatorApiController;
    private ReaderDefinitionController readerDefinitionController;
    private Gson gson;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = TestUtils.getClient();

        coordinatorApiController = new CoordinatorApiController(client, TestUtils.MOCK_URI);
        readerDefinitionController = coordinatorApiController.getReaderDefinitionController();
        gson = new Gson();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getReaderDefinitionsTest() {
        ReaderDefinition testReaderDefinition = new ReaderDefinition( "test-xarray", "xarray-test.local" , "TestFacility", null, null, new Placement(1, 2,5, 0,180,90, "1"), ReaderType.XARRAY);
        List<ReaderDefinition> testDefinitions = new ArrayList<>();
        testDefinitions.add(testReaderDefinition);

        stubFor(get(urlEqualTo("/configuration/v1/readerDefinitions/show")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testDefinitions))));

        List<ReaderDefinition> configurations = readerDefinitionController.getReaderDefinitions();

        Assert.assertEquals(configurations.size(), 1);
        Assert.assertThat(configurations, instanceOf(ArrayList.class));
        Assert.assertThat(configurations.get(0), instanceOf(ReaderDefinition.class));
        Assert.assertEquals(configurations.get(0),testReaderDefinition);
    }

    @Test
    public void getReaderDefinitionTest() {
        ReaderDefinition testReaderDefinition = new ReaderDefinition( "test-xarray", "xarray-test.local" , "TestFacility", null, null, new Placement(1, 2,5, 0,180,90, "1"), ReaderType.XARRAY);

        stubFor(get(urlEqualTo("/configuration/v1/readerDefinitions/show/Test_Reader_Definition")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testReaderDefinition))));

        ReaderDefinition readerDefinitionResult =  readerDefinitionController.getReaderDefinition("Test_Reader_Definition");
        Assert.assertEquals(readerDefinitionResult, testReaderDefinition);
        Assert.assertThat(readerDefinitionResult, instanceOf(ReaderDefinition.class));

    }

    @Test
    public void createReaderDefinitionTest() {

    }

    @Test
    public void createOrUpdateReaderDefinition() {
        ReaderDefinition reader = new ReaderDefinition();
        reader.setName("READER");
        reader.setAddress("192.168.0.1");
        reader.setFacility("FAC");
        reader.setReaderZone("ZONE");
        reader.setType(ReaderType.SPEEDWAY);

        stubFor(put(urlEqualTo("/configuration/v1/readerDefinitions/createOrReplace")).willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody(gson.toJson(reader))));

        Response response = readerDefinitionController.updateReaderDefinitionAsResponse(reader);
        Assert.assertEquals(200, response.getStatus());
        response.close();

        ReaderDefinition responseReader = readerDefinitionController.updateReaderDefinition(reader);
        Assert.assertEquals(reader, responseReader);
    }
}