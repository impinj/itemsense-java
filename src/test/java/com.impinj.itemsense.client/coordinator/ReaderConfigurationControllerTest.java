package com.impinj.itemsense.client.coordinator;


import com.google.gson.Gson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.readerconfiguration.Filter;
import com.impinj.itemsense.client.coordinator.readerconfiguration.InventoryReaderConfigDetails;
import com.impinj.itemsense.client.coordinator.readerconfiguration.LocationReaderConfigDetails;
import com.impinj.itemsense.client.coordinator.readerconfiguration.Operation;
import com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderConfiguration;
import com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderConfigurationController;
import com.impinj.itemsense.client.coordinator.readerconfiguration.ReaderMode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.instanceOf;

public class ReaderConfigurationControllerTest {

    private CoordinatorApiController coordinatorApiController;
    private ReaderConfigurationController readerConfigurationController;
    private Gson gson;

    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);

    @Rule
    public WireMockClassRule instanceRule = wireMockRule;


    @Before
    public void setUp() throws Exception {

        Client client = TestUtils.getClient();

        coordinatorApiController = new CoordinatorApiController(client, TestUtils.MOCK_URI);
        readerConfigurationController = coordinatorApiController.getReaderConfigurationController();
        gson = new Gson();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getReaderConfigurationsTest() {
        InventoryReaderConfigDetails details = new InventoryReaderConfigDetails();
        details.setReaderMode(ReaderMode.MODE_1002);
        details.setSession(1);

        ReaderConfiguration testReaderConfiguration = new ReaderConfiguration("Test_Configuration", Operation.INVENTORY, details);

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
    }

    @Test
    public void getReaderConfigurationTest() throws IOException {
        LocationReaderConfigDetails details = new LocationReaderConfigDetails();
        details.setReaderMode(ReaderMode.MODE_1002);
        details.setSession(1);
        details.setFilter(new Filter());
        ReaderConfiguration testReaderConfiguration = new ReaderConfiguration("Test_Configuration", Operation.LOCATION, details);

        String str = gson.toJson(testReaderConfiguration);

        stubFor(get(urlEqualTo("/configuration/v1/readerConfigurations/show/Test_Configuration")).willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody(str)));

        ReaderConfiguration readerConfigurationResult =  readerConfigurationController.getReaderConfiguration("Test_Configuration");
        Assert.assertEquals(testReaderConfiguration, readerConfigurationResult);
        Assert.assertThat(readerConfigurationResult, instanceOf(ReaderConfiguration.class));
        Assert.assertThat(readerConfigurationResult.getConfiguration(), instanceOf(LocationReaderConfigDetails.class));

    }
}