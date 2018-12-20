package com.impinj.itemsense.client.coordinator.readerconfiguration;

import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


public class ReaderConfigurationController {

  private static final String BASE_PATH = "/configuration/v1/readerConfigurations";
  private WebTarget target;

  public ReaderConfigurationController(WebTarget target) {
    this.target = target;
  }

  public Response createReaderConfigurationAsResponse(ReaderConfiguration readerConfiguration) {
    return RestApiHelper.post(readerConfiguration, target, BASE_PATH, "create");
  }

  public Response updateReaderConfigurationAsResponse(ReaderConfiguration readerConfiguration) {
    return RestApiHelper.put(readerConfiguration, target, BASE_PATH, "createOrReplace");
  }

  public Response getReaderConfigurationAsResponse(String readerConfigurationName) {
    return RestApiHelper.get(target, BASE_PATH, "show", readerConfigurationName);
  }

  public Response getReaderConfigurationsAsResponse() {
    return RestApiHelper.get(target, BASE_PATH, "show");
  }

  public Response deleteReaderConfiguration(String readerConfigurationName) {
    return RestApiHelper.delete(target, BASE_PATH, "destroy", readerConfigurationName);
  }

  public ReaderConfiguration getReaderConfiguration(String readerConfigurationName) {
    return this.getReaderConfigurationAsResponse(readerConfigurationName)
        .readEntity(ReaderConfiguration.class);
  }

  public List<ReaderConfiguration> getReaderConfigurations() {
    return this.getReaderConfigurationsAsResponse()
        .readEntity(new GenericType<List<ReaderConfiguration>>() {});
  }

  public ReaderConfiguration createReaderConfiguration(ReaderConfiguration readerConfiguration) {
    return this.createReaderConfigurationAsResponse(readerConfiguration)
        .readEntity(ReaderConfiguration.class);
  }

  public ReaderConfiguration updateReaderConfiguration(ReaderConfiguration readerConfiguration) {
    return this.updateReaderConfigurationAsResponse(readerConfiguration)
        .readEntity(ReaderConfiguration.class);
  }

}
