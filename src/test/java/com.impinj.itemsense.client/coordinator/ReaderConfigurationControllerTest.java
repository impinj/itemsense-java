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
    public void getReaderConfigurationsTest() {
        ReaderConfigurationDetails details = new ReaderConfigurationDetails(ReaderMode.MODE_1002, SearchMode.DUAL_TARGET, 1, 24, true, new int[] {1,2,3,4,5}, new Filter(), new ChannelConfig(), new ReportConfig());
        ReaderConfiguration testReaderConfiguration = new ReaderConfiguration("Test_Configuration", Operation.NORMAL, details);
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
        //Assert.assertEquals(testReaderConfiguration, configurations.get(0));
    }

    @Test
    public void getReaderConfigurationTest() {
        ReaderConfigurationDetails details = new ReaderConfigurationDetails(ReaderMode.MODE_1002, SearchMode.DUAL_TARGET, 1, 24, true, new int[] {1,2,3,4,5}, new Filter(), new ChannelConfig(), new ReportConfig());
        ReaderConfiguration testReaderConfiguration = new ReaderConfiguration("Test_Configuration", Operation.NORMAL, details);

        String str = gson.toJson(testReaderConfiguration);

        stubFor(get(urlEqualTo("/configuration/v1/readerConfigurations/show/Test_Configuration")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(str)));

        ReaderConfiguration readerConfigurationResult =  readerConfigurationController.getReaderConfiguration("Test_Configuration");
        Assert.assertEquals(testReaderConfiguration, readerConfigurationResult);
        Assert.assertThat(readerConfigurationResult, instanceOf(ReaderConfiguration.class));

    }

    @Test
    public void testIllegalReaderConfigurationEnums() {
        String readerConfigResponse = "{\"name\":\"SPEEDWAY_CONFIG\",\"configuration\":{\"readerMode\":\"ILLEGAL MODE\",\"session\":0,\"searchMode\":\"ILLEGAL SEARCH MODE\",\"tagPopulationEstimate\":32,\"transmitPowerInDbm\":null,\"polarization\":false,\"antennas\":[1,2],\"filter\":null,\"channelConfig\":null,\"reportConfig\":null},\"operation\":\"ILLEGAL OPERATION\"}}";
        ReaderConfiguration dummyReaderConfiguration = new ReaderConfiguration();
        String dummyString = gson.toJson(dummyReaderConfiguration);
        System.out.println(dummyString);

        stubFor(post(urlEqualTo("/configuration/v1/readerConfigurations/create")).willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody(readerConfigResponse)));

        ReaderConfiguration config = readerConfigurationController.createReaderConfiguration(new ReaderConfiguration());

        Assert.assertNull(config.getOperation());
        Assert.assertNull(config.getReaderMode());
        Assert.assertNull(config.getSearchMode());
    }


}