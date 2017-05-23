package com.impinj.itemsense.client.coordinator;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.impinj.itemsense.client.TestUtils;
import com.impinj.itemsense.client.coordinator.thresholds.ThresholdAntennaConfiguration;
import com.impinj.itemsense.client.coordinator.thresholds.ThresholdAntennaConfigurationAntenna;
import com.impinj.itemsense.client.coordinator.thresholds.ThresholdController;
import com.impinj.itemsense.client.coordinator.thresholds.Threshold;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

public class ThresholdControllerTest {

  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private ThresholdController thresholdController;
  private Gson gson;

  @Before
  public void setUp() throws Exception {
    Client client = TestUtils.getClient();

    thresholdController = new CoordinatorApiController(client, TestUtils.MOCK_URI)
        .getThresholdController();

    gson = new Gson();
  }

  @Test
  public void testGetThresholds() {
    List<Threshold> expected = ImmutableList.of(
        Threshold.builder()
            .id(1)
            .name("FOO")
            .facility("DEFAULT")
            .build(),
        Threshold.builder()
            .id(2)
            .name("FOO1")
            .facility("DEFAULT1")
            .build());

    String requestBody = gson.toJson(expected);

    stubFor(get(urlEqualTo("/configuration/v1/thresholds"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = thresholdController.getThresholdsAsResponse();
    Assert.assertEquals(200, response.getStatus());

    List<Threshold> actual = response.readEntity(new GenericType<List<Threshold>>() {});
    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGetThreshold() {
    Threshold expected = Threshold.builder()
        .id(1)
        .name("FOO")
        .facility("DEFAULT")
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(get(urlEqualTo("/configuration/v1/thresholds/1"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = thresholdController.getThresholdAsResponse(1);
    Assert.assertEquals(200, response.getStatus());

    Threshold actual = response.readEntity(new GenericType<Threshold>() {});
    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testPostThreshold() {
    Threshold expected = Threshold.builder()
        .name("FOO")
        .facility("DEFAULT")
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(post(urlEqualTo("/configuration/v1/thresholds"))
                .withRequestBody(equalToJson(requestBody, true, true))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = thresholdController.createThresholdAsResponse(expected);
    Assert.assertEquals(200, response.getStatus());

    Threshold actual = response.readEntity(new GenericType<Threshold>() {});
    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testPutThreshold() {
    Threshold expected = Threshold.builder()
        .id(5)
        .name("FOO")
        .facility("DEFAULT")
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(put(urlEqualTo("/configuration/v1/thresholds/5"))
                .withRequestBody(equalToJson(requestBody, true, true))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = thresholdController.updateThresholdAsResponse(expected);
    Assert.assertEquals(200, response.getStatus());

    Threshold actual = response.readEntity(new GenericType<Threshold>() {});
    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testDeleteThreshold() {
    stubFor(delete(urlEqualTo("/configuration/v1/thresholds/1"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")));

    Response response = thresholdController.deleteThresholdAsResponse(1);
    Assert.assertEquals(200, response.getStatus());
  }

  @Test
  public void testGetAntennaConfig() {
    ThresholdAntennaConfiguration expected = ThresholdAntennaConfiguration
        .builder()
        .id(5)
        .name("FOO")
        .out(ImmutableList.of(ThresholdAntennaConfigurationAntenna.builder().antennaId(1).build()))
        .in(ImmutableList.of(ThresholdAntennaConfigurationAntenna.builder().antennaId(2).build()))
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(get(urlEqualTo("/configuration/v1/thresholds/antennaConfigurations/5"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = thresholdController.getAntennaConfigurationAsResponse(5);
    Assert.assertEquals(200, response.getStatus());

    ThresholdAntennaConfiguration actual = response
        .readEntity(new GenericType<ThresholdAntennaConfiguration>() {});

    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGetAntennaConfigs() {
    List<ThresholdAntennaConfiguration> expected = ImmutableList.of(
        ThresholdAntennaConfiguration
            .builder()
            .id(5)
            .name("FOO")
            .out(ImmutableList
                     .of(ThresholdAntennaConfigurationAntenna.builder().antennaId(1).build()))
            .in(ImmutableList
                    .of(ThresholdAntennaConfigurationAntenna.builder().antennaId(2).build()))
            .build(),
        ThresholdAntennaConfiguration
            .builder()
            .id(6)
            .name("FOO1")
            .out(ImmutableList
                     .of(ThresholdAntennaConfigurationAntenna.builder().antennaId(1).build()))
            .in(ImmutableList
                    .of(ThresholdAntennaConfigurationAntenna.builder().antennaId(2).build()))
            .build());

    String requestBody = gson.toJson(expected);

    stubFor(get(urlEqualTo("/configuration/v1/thresholds/antennaConfigurations"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = thresholdController.getAntennaConfigurationsAsResponse();
    Assert.assertEquals(200, response.getStatus());

    List<ThresholdAntennaConfiguration> actual = response
        .readEntity(new GenericType<List<ThresholdAntennaConfiguration>>() {});

    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testPostAntennaConfig() {
    ThresholdAntennaConfiguration expected = ThresholdAntennaConfiguration
        .builder()
        .id(5)
        .name("FOO")
        .out(ImmutableList.of(ThresholdAntennaConfigurationAntenna.builder().antennaId(1).build()))
        .in(ImmutableList.of(ThresholdAntennaConfigurationAntenna.builder().antennaId(2).build()))
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(post(urlEqualTo("/configuration/v1/thresholds/antennaConfigurations"))
                .withRequestBody(equalToJson(requestBody, true, true))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = thresholdController.createAntennaConfigurationAsResponse(expected);
    Assert.assertEquals(200, response.getStatus());

    ThresholdAntennaConfiguration actual = response
        .readEntity(new GenericType<ThresholdAntennaConfiguration>() {});

    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testPutAntennaConfig() {
    ThresholdAntennaConfiguration expected = ThresholdAntennaConfiguration
        .builder()
        .id(5)
        .name("FOO")
        .out(ImmutableList.of(ThresholdAntennaConfigurationAntenna.builder().antennaId(1).build()))
        .in(ImmutableList.of(ThresholdAntennaConfigurationAntenna.builder().antennaId(2).build()))
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(put(urlEqualTo("/configuration/v1/thresholds/antennaConfigurations/5"))
                .withRequestBody(equalToJson(requestBody, true, true))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = thresholdController.updateAntennaConfigurationAsResponse(expected);
    Assert.assertEquals(200, response.getStatus());

    ThresholdAntennaConfiguration actual = response
        .readEntity(new GenericType<ThresholdAntennaConfiguration>() {});

    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testDeleteAntennaConfig() {
    stubFor(delete(urlEqualTo("/configuration/v1/thresholds/antennaConfigurations/55"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")));

    Response response = thresholdController.deleteAntennaConfigurationAsResponse(55);
    Assert.assertEquals(200, response.getStatus());
  }
}