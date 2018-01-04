package com.impinj.itemsense.client.coordinator.readerdefinition;


import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ReaderDefinitionController {

  private static final String BASE_PATH = "/configuration/v1/readerDefinitions";
  private WebTarget target;
  private Client client;

  public ReaderDefinitionController(WebTarget target, Client client) {
    this.target = target;
    this.client = client;
  }

  public Response getReaderGroupsAsResponse() {
    return RestApiHelper.get(target, BASE_PATH, "groups");
  }

  public Set<String> getReaderGroups() {
    return this.getReaderGroupsAsResponse()
        .readEntity(new GenericType<Set<String>>() {});
  }

  public Response createReaderDefinitionAsResponse(ReaderDefinition readerDefinition) {
    return RestApiHelper.post(readerDefinition, target, BASE_PATH, "create");
  }

  public Response updateReaderDefinitionAsResponse(ReaderDefinition readerDefinition) {
    return RestApiHelper.put(readerDefinition, target, BASE_PATH, "createOrReplace");
  }

  public Response getReaderDefinitionAsResponse(String readerDefinitionName) {
    return RestApiHelper.get(target, BASE_PATH, "show", readerDefinitionName);
  }

  public Response getReaderDefinitionsAsResponse() {
    return RestApiHelper.get(target, BASE_PATH, "show");
  }

  public Response deleteReaderDefinition(String readerDefinitionName) {
    return RestApiHelper.delete(target, BASE_PATH, "destroy", readerDefinitionName);
  }

  public ReaderDefinition createReaderDefinition(ReaderDefinition readerDefinition) {
    return this.createReaderDefinitionAsResponse(readerDefinition)
        .readEntity(ReaderDefinition.class);
  }

  public ReaderDefinition updateReaderDefinition(ReaderDefinition readerDefinition) {
    return this.updateReaderDefinitionAsResponse(readerDefinition)
        .readEntity(ReaderDefinition.class);
  }

  public ReaderDefinition getReaderDefinition(String readerDefinitionName) {
    return this.getReaderDefinitionAsResponse(readerDefinitionName)
        .readEntity(ReaderDefinition.class);
  }

  public List<ReaderDefinition> getReaderDefinitions() {
    return this.getReaderDefinitionsAsResponse()
        .readEntity(new GenericType<List<ReaderDefinition>>() {});
  }

  public ReaderFeatureStatus configureFeature(String readerName, FeatureRequest request) {
    Response response =
        RestApiHelper.post(request, target, BASE_PATH, readerName, "featureChanges");
    if (response.getStatus() == 202) {
      String locationUri = response.getHeaderString("Location");
      return client.target(locationUri)
          .request(MediaType.APPLICATION_JSON_TYPE)
          .get()
          .readEntity(ReaderFeatureStatus.class);
    } else {
      throw new ProcessingException("Failed to create feature change request");
    }
  }

  public ReaderFeatureStatus getFeatureStatus(String readerName, ReaderFeature feature) {
    return RestApiHelper
        .get(target, BASE_PATH, readerName, "featureChanges", feature.name())
        .readEntity(ReaderFeatureStatus.class);
  }

  public Map<ReaderFeature, ReaderFeatureStatus> getActiveFeatureRequests(String readerName) {
    return RestApiHelper
        .get(target, BASE_PATH, readerName, "featureChanges")
        .readEntity(new GenericType<Map<ReaderFeature, ReaderFeatureStatus>>(){});
  }
}
