package com.impinj.itemsense.client.coordinator.dockdoors;

import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class DockDoorController {

  private static final String BASE_PATH = "/configuration/v1/dockDoors";
  private static final String ANTENNA_BASE_PATH = BASE_PATH + "/antennaConfigurations";
  private WebTarget target;

  public DockDoorController(WebTarget target) {
    this.target = target;
  }

  public Response getDockDoorsAsResponse() {
    return RestApiHelper.get(target, BASE_PATH);
  }

  public List<Door> getDockDoors() {
    return getDockDoorsAsResponse().readEntity(new GenericType<List<Door>>() {});
  }

  public Response getDockDoorAsResponse(Integer id) {
    return RestApiHelper.get(target, BASE_PATH, id.toString());
  }

  public Door getDockDoor(Integer id) {
    return getDockDoorAsResponse(id).readEntity(new GenericType<Door>() {});
  }

  public Response createDockDoorAsResponse(Door door) {
    return RestApiHelper.post(door, target, BASE_PATH);
  }

  public Door createDockDoor(Door door) {
    return createDockDoorAsResponse(door).readEntity(new GenericType<Door>() {});
  }

  public Response updateDockDoorAsResponse(Door door) {
    return RestApiHelper.put(door, target, BASE_PATH, door.getId().toString());
  }

  public Door updateDockDoor(Door door) {
    return updateDockDoorAsResponse(door).readEntity(new GenericType<Door>() {});
  }

  public Response deleteDockDoorAsResponse(Integer id) {
    return RestApiHelper.delete(target, BASE_PATH, id.toString());
  }

  public void deleteDockDoor(Integer id) {
    getDockDoorAsResponse(id);
  }

  //********************************
  //Antenna Configuration operations
  //********************************

  public Response getAntennaConfigurationsAsResponse() {
    return RestApiHelper.get(target, ANTENNA_BASE_PATH);
  }

  public List<DockDoorAntennaConfiguration> getAntennaConfigurations() {
    return getAntennaConfigurationsAsResponse()
        .readEntity(new GenericType<List<DockDoorAntennaConfiguration>>() {});
  }

  public Response getAntennaConfigurationAsResponse(Integer id) {
    return RestApiHelper.get(target, ANTENNA_BASE_PATH, id.toString());
  }

  public DockDoorAntennaConfiguration getAntennaConfiguration(Integer id) {
    return getAntennaConfigurationAsResponse(id)
        .readEntity(new GenericType<DockDoorAntennaConfiguration>() {});
  }

  public Response createAntennaConfigurationAsResponse(
      DockDoorAntennaConfiguration dockDoorAntennaConfiguration) {

    return RestApiHelper.post(dockDoorAntennaConfiguration, target, ANTENNA_BASE_PATH);
  }

  public DockDoorAntennaConfiguration createAntennaConfiguration(
      DockDoorAntennaConfiguration dockDoorAntennaConfiguration) {

    return createAntennaConfigurationAsResponse(dockDoorAntennaConfiguration)
        .readEntity(new GenericType<DockDoorAntennaConfiguration>() {});
  }

  public Response updateAntennaConfigurationAsResponse(
      DockDoorAntennaConfiguration dockDoorAntennaConfiguration) {

    return RestApiHelper.put(dockDoorAntennaConfiguration, target, ANTENNA_BASE_PATH,
                             dockDoorAntennaConfiguration.getId().toString());
  }

  public DockDoorAntennaConfiguration updateAntennaConfiguration(
      DockDoorAntennaConfiguration dockDoorAntennaConfiguration) {

    return updateAntennaConfigurationAsResponse(dockDoorAntennaConfiguration)
        .readEntity(new GenericType<DockDoorAntennaConfiguration>() {});
  }

  public Response deleteAntennaConfigurationAsResponse(Integer id) {

    return RestApiHelper.delete(target, ANTENNA_BASE_PATH, id.toString());
  }

  public void deleteAntennaConfigurationAs(Integer id) {
    deleteAntennaConfigurationAsResponse(id);
  }
}
