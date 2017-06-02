package com.impinj.itemsense.client.coordinator.thresholds;

import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ThresholdController {

  private static final String BASE_PATH = "/configuration/v1/thresholds";
  private static final String ANTENNA_BASE_PATH = BASE_PATH + "/antennaConfigurations";
  private WebTarget target;

  public ThresholdController(WebTarget target) {
    this.target = target;
  }

  public Response getThresholdsAsResponse() {
    return RestApiHelper.get(target, BASE_PATH);
  }

  public List<Threshold> getThresholds() {
    return getThresholdsAsResponse().readEntity(new GenericType<List<Threshold>>() {});
  }

  public Response getThresholdAsResponse(Integer id) {
    return RestApiHelper.get(target, BASE_PATH, id.toString());
  }

  public Threshold getThreshold(Integer id) {
    return getThresholdAsResponse(id).readEntity(new GenericType<Threshold>() {});
  }

  public Response createThresholdAsResponse(Threshold threshold) {
    return RestApiHelper.post(threshold, target, BASE_PATH);
  }

  public Threshold createThreshold(Threshold threshold) {
    return createThresholdAsResponse(threshold).readEntity(new GenericType<Threshold>() {});
  }

  public Response updateThresholdAsResponse(Threshold threshold) {
    return RestApiHelper.put(threshold, target, BASE_PATH, threshold.getId().toString());
  }

  public Threshold updateThreshold(Threshold threshold) {
    return updateThresholdAsResponse(threshold).readEntity(new GenericType<Threshold>() {});
  }

  public Response deleteThresholdAsResponse(Integer id) {
    return RestApiHelper.delete(target, BASE_PATH, id.toString());
  }

  public void deleteThreshold(Integer id) {
    getThresholdAsResponse(id);
  }

  //********************************
  //Antenna Configuration operations
  //********************************

  public Response getAntennaConfigurationsAsResponse() {
    return RestApiHelper.get(target, ANTENNA_BASE_PATH);
  }

  public List<ThresholdAntennaConfiguration> getAntennaConfigurations() {
    return getAntennaConfigurationsAsResponse()
        .readEntity(new GenericType<List<ThresholdAntennaConfiguration>>() {});
  }

  public Response getAntennaConfigurationAsResponse(Integer id) {
    return RestApiHelper.get(target, ANTENNA_BASE_PATH, id.toString());
  }

  public ThresholdAntennaConfiguration getAntennaConfiguration(Integer id) {
    return getAntennaConfigurationAsResponse(id)
        .readEntity(new GenericType<ThresholdAntennaConfiguration>() {});
  }

  public Response createAntennaConfigurationAsResponse(
      ThresholdAntennaConfiguration thresholdAntennaConfiguration) {

    return RestApiHelper.post(thresholdAntennaConfiguration, target, ANTENNA_BASE_PATH);
  }

  public ThresholdAntennaConfiguration createAntennaConfiguration(
      ThresholdAntennaConfiguration thresholdAntennaConfiguration) {

    return createAntennaConfigurationAsResponse(thresholdAntennaConfiguration)
        .readEntity(new GenericType<ThresholdAntennaConfiguration>() {});
  }

  public Response updateAntennaConfigurationAsResponse(
      ThresholdAntennaConfiguration thresholdAntennaConfiguration) {

    return RestApiHelper.put(thresholdAntennaConfiguration, target, ANTENNA_BASE_PATH,
                             thresholdAntennaConfiguration.getId().toString());
  }

  public ThresholdAntennaConfiguration updateAntennaConfiguration(
      ThresholdAntennaConfiguration thresholdAntennaConfiguration) {

    return updateAntennaConfigurationAsResponse(thresholdAntennaConfiguration)
        .readEntity(new GenericType<ThresholdAntennaConfiguration>() {});
  }

  public Response deleteAntennaConfigurationAsResponse(Integer id) {

    return RestApiHelper.delete(target, ANTENNA_BASE_PATH, id.toString());
  }

  public void deleteAntennaConfiguration(Integer id) {
    deleteAntennaConfigurationAsResponse(id);
  }

  public Response repalceAndDeleteAntennaConfigurationAsResponse(int id, int replacementId) {
    return target
        .path(String.join("/", ANTENNA_BASE_PATH, Integer.toString(id)))
        .queryParam("replacementId", replacementId)
        .request(MediaType.APPLICATION_JSON_TYPE)
        .delete();
  }

  public void replaceAndDeleteAntennaConfiguration(int id, int replacementId) {
    repalceAndDeleteAntennaConfigurationAsResponse(id, replacementId);
  }
}
