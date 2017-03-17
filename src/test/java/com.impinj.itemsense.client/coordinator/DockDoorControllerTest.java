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
import com.impinj.itemsense.client.coordinator.dockdoors.DockDoorAntennaConfiguration;
import com.impinj.itemsense.client.coordinator.dockdoors.DockDoorAntennaConfigurationAntenna;
import com.impinj.itemsense.client.coordinator.dockdoors.DockDoorController;
import com.impinj.itemsense.client.coordinator.dockdoors.Door;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

public class DockDoorControllerTest {

  @ClassRule
  public static WireMockClassRule wireMockRule = new WireMockClassRule(TestUtils.MOCK_PORT);
  @Rule
  public WireMockClassRule instanceRule = wireMockRule;
  private DockDoorController dockDoorController;
  private Gson gson;

  @Before
  public void setUp() throws Exception {
    Client client = TestUtils.getClient();

    dockDoorController = new CoordinatorApiController(client, TestUtils.MOCK_URI)
        .getDockDoorController();

    gson = new Gson();
  }

  @Test
  public void testGetDockDoors() {
    List<Door> expected = ImmutableList.of(
        Door.builder()
            .id(1)
            .name("FOO")
            .facility("DEFAULT")
            .build(),
        Door.builder()
            .id(2)
            .name("FOO1")
            .facility("DEFAULT1")
            .build());

    String requestBody = gson.toJson(expected);

    stubFor(get(urlEqualTo("/configuration/v1/dockDoors"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = dockDoorController.getDockDoorsAsResponse();
    Assert.assertEquals(200, response.getStatus());

    List<Door> actual = response.readEntity(new GenericType<List<Door>>() {});
    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGetDockDoor() {
    Door expected = Door.builder()
        .id(1)
        .name("FOO")
        .facility("DEFAULT")
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(get(urlEqualTo("/configuration/v1/dockDoors/1"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = dockDoorController.getDockDoorAsResponse(1);
    Assert.assertEquals(200, response.getStatus());

    Door actual = response.readEntity(new GenericType<Door>() {});
    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testPostDockDoor() {
    Door expected = Door.builder()
        .name("FOO")
        .facility("DEFAULT")
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(post(urlEqualTo("/configuration/v1/dockDoors"))
                .withRequestBody(equalToJson(requestBody, true, true))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = dockDoorController.createDockDoorAsResponse(expected);
    Assert.assertEquals(200, response.getStatus());

    Door actual = response.readEntity(new GenericType<Door>() {});
    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testPutDockDoor() {
    Door expected = Door.builder()
        .id(5)
        .name("FOO")
        .facility("DEFAULT")
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(put(urlEqualTo("/configuration/v1/dockDoors/5"))
                .withRequestBody(equalToJson(requestBody, true, true))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = dockDoorController.updateDockDoorAsResponse(expected);
    Assert.assertEquals(200, response.getStatus());

    Door actual = response.readEntity(new GenericType<Door>() {});
    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testDeleteDockDoor() {
    stubFor(delete(urlEqualTo("/configuration/v1/dockDoors/1"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")));

    Response response = dockDoorController.deleteDockDoorAsResponse(1);
    Assert.assertEquals(200, response.getStatus());
  }

  @Test
  public void testGetAntennaConfig() {
    DockDoorAntennaConfiguration expected = DockDoorAntennaConfiguration
        .builder()
        .id(5)
        .name("FOO")
        .out(ImmutableList.of(DockDoorAntennaConfigurationAntenna.builder().antennaId(1).build()))
        .in(ImmutableList.of(DockDoorAntennaConfigurationAntenna.builder().antennaId(2).build()))
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(get(urlEqualTo("/configuration/v1/dockDoors/antennaConfigurations/5"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = dockDoorController.getAntennaConfigurationAsResponse(5);
    Assert.assertEquals(200, response.getStatus());

    DockDoorAntennaConfiguration actual = response
        .readEntity(new GenericType<DockDoorAntennaConfiguration>() {});

    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testGetAntennaConfigs() {
    List<DockDoorAntennaConfiguration> expected = ImmutableList.of(
        DockDoorAntennaConfiguration
            .builder()
            .id(5)
            .name("FOO")
            .out(ImmutableList
                     .of(DockDoorAntennaConfigurationAntenna.builder().antennaId(1).build()))
            .in(ImmutableList
                    .of(DockDoorAntennaConfigurationAntenna.builder().antennaId(2).build()))
            .build(),
        DockDoorAntennaConfiguration
            .builder()
            .id(6)
            .name("FOO1")
            .out(ImmutableList
                     .of(DockDoorAntennaConfigurationAntenna.builder().antennaId(1).build()))
            .in(ImmutableList
                    .of(DockDoorAntennaConfigurationAntenna.builder().antennaId(2).build()))
            .build());

    String requestBody = gson.toJson(expected);

    stubFor(get(urlEqualTo("/configuration/v1/dockDoors/antennaConfigurations"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = dockDoorController.getAntennaConfigurationsAsResponse();
    Assert.assertEquals(200, response.getStatus());

    List<DockDoorAntennaConfiguration> actual = response
        .readEntity(new GenericType<List<DockDoorAntennaConfiguration>>() {});

    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testPostAntennaConfig() {
    DockDoorAntennaConfiguration expected = DockDoorAntennaConfiguration
        .builder()
        .id(5)
        .name("FOO")
        .out(ImmutableList.of(DockDoorAntennaConfigurationAntenna.builder().antennaId(1).build()))
        .in(ImmutableList.of(DockDoorAntennaConfigurationAntenna.builder().antennaId(2).build()))
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(post(urlEqualTo("/configuration/v1/dockDoors/antennaConfigurations"))
                .withRequestBody(equalToJson(requestBody, true, true))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = dockDoorController.createAntennaConfigurationAsResponse(expected);
    Assert.assertEquals(200, response.getStatus());

    DockDoorAntennaConfiguration actual = response
        .readEntity(new GenericType<DockDoorAntennaConfiguration>() {});

    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testPutAntennaConfig() {
    DockDoorAntennaConfiguration expected = DockDoorAntennaConfiguration
        .builder()
        .id(5)
        .name("FOO")
        .out(ImmutableList.of(DockDoorAntennaConfigurationAntenna.builder().antennaId(1).build()))
        .in(ImmutableList.of(DockDoorAntennaConfigurationAntenna.builder().antennaId(2).build()))
        .build();

    String requestBody = gson.toJson(expected);

    stubFor(put(urlEqualTo("/configuration/v1/dockDoors/antennaConfigurations/5"))
                .withRequestBody(equalToJson(requestBody, true, true))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(requestBody)));

    Response response = dockDoorController.updateAntennaConfigurationAsResponse(expected);
    Assert.assertEquals(200, response.getStatus());

    DockDoorAntennaConfiguration actual = response
        .readEntity(new GenericType<DockDoorAntennaConfiguration>() {});

    response.close();

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testDeleteAntennaConfig() {
    stubFor(delete(urlEqualTo("/configuration/v1/dockDoors/antennaConfigurations/55"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")));

    Response response = dockDoorController.deleteAntennaConfigurationAsResponse(55);
    Assert.assertEquals(200, response.getStatus());
  }
}