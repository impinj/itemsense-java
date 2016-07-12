package com.impinj.itemsense.client.coordinator;

/**
 * Created by jcombopi on 1/29/16.
 */

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.coordinator.readerdefintion.Placement;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderDefinition;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderDefinitionController;
import com.impinj.itemsense.client.coordinator.readerdefintion.ReaderType;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.CoreMatchers.instanceOf;



/**
 * Created by jcombopi on 1/27/16.
 */
public class ReaderDefinitionControllerTest {

    private CoordinatorApiController coordinatorApiController;
    private ReaderDefinitionController readerDefinitionController;
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
        readerDefinitionController = coordinatorApiController.getReaderDefinitionController();
        gson = new Gson();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void GetReaderDefinitionsTest(){
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
    public void GetReaderDefinitionTest(){
        ReaderDefinition testReaderDefinition = new ReaderDefinition( "test-xarray", "xarray-test.local" , "TestFacility", null, null, new Placement(1, 2,5, 0,180,90, "1"), ReaderType.XARRAY);

        stubFor(get(urlEqualTo("/configuration/v1/readerDefinitions/show/Test_Reader_Definition")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testReaderDefinition))));

        ReaderDefinition readerDefinitionResult =  readerDefinitionController.getReaderDefinition("Test_Reader_Definition");
        Assert.assertEquals(readerDefinitionResult, testReaderDefinition);
        Assert.assertThat(readerDefinitionResult, instanceOf(ReaderDefinition.class));

    }
}