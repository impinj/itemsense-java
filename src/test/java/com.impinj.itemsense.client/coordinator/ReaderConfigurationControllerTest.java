package com.impinj.itemsense.client.coordinator;

/**
 * Created by jcombopi on 1/29/16.
 */

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.gson.Gson;
import com.impinj.itemsense.client.coordinator.readerconfiguration.*;
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
public class ReaderConfigurationControllerTest {

    private CoordinatorApiController coordinatorApiController;
    private ReaderConfigurationController readerConfigurationController;
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
        readerConfigurationController = coordinatorApiController.getReaderConfigurationController();
        gson = new Gson();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void GetReaderConfigurationsTest(){
        ReaderConfiguration testReaderConfiguration = new ReaderConfiguration("Test_Configuration", Operation.NORMAL, ReaderMode.MODE_1002, SearchMode.DUAL_TARGET, 1, 24, 30, true, true,new int[] {1,2,3,4,5}, new Filter(), new ChannelConfig(), new ReportConfig());
        ArrayList<ReaderConfiguration> testConfigurations = new ArrayList<>();
        testConfigurations.add(testReaderConfiguration);

        stubFor(get(urlEqualTo("/configuration/v1/readerConfigurations/show")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testConfigurations))));

        List<ReaderConfiguration> configurations = readerConfigurationController.getReaderConfigurations();

        Assert.assertEquals(configurations.size(), 1);
        Assert.assertThat(configurations, instanceOf(ArrayList.class));
        Assert.assertThat(configurations.get(0), instanceOf(ReaderConfiguration.class));
        Assert.assertEquals(configurations.get(0),testReaderConfiguration);
    }

    @Test
    public void GetReaderConfigurationTest(){
        ReaderConfiguration testReaderConfiguration =  new ReaderConfiguration("Test_Configuration", Operation.NORMAL, ReaderMode.MODE_1002, SearchMode.DUAL_TARGET, 1, 24, 30, true, true,new int[] {1,2,3,4,5}, new Filter(), new ChannelConfig(), new ReportConfig());

        stubFor(get(urlEqualTo("/configuration/v1/readerConfigurations/show/Test_Configuration")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(gson.toJson(testReaderConfiguration))));

        ReaderConfiguration readerConfigurationResult =  readerConfigurationController.getReaderConfiguration("Test_Configuration");
        Assert.assertEquals(readerConfigurationResult, testReaderConfiguration);
        Assert.assertThat(readerConfigurationResult, instanceOf(ReaderConfiguration.class));

    }





}