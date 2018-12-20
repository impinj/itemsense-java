package com.impinj.itemsense.client.coordinator.softwareversions;

import com.impinj.itemsense.client.coordinator.softwareupgrades.ImageType;
import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class SoftwareVersionsController {

  private static final String BASE_PATH = "configuration/v1/softwareVersions";
  private WebTarget target;

  public SoftwareVersionsController(WebTarget target) {
    this.target = target;
  }

  public List<VersionInfoView> getVersions(ImageType imageType) {
    return getVersionsAsResponse(imageType)
        .readEntity(new GenericType<List<VersionInfoView>>() {});
  }

  public Response getVersionsAsResponse(ImageType imageType) {
    Response response = RestApiHelper.get(target, BASE_PATH, "list", imageType.name());
    return response;
  }

  public VersionInfoView getVersion(ImageType imageType, String softwareVersionId) {
    return getVersionAsResponse(imageType, softwareVersionId).readEntity(VersionInfoView.class);
  }

  public Response getVersionAsResponse(ImageType imageType, String softwareVersionId) {
    return RestApiHelper.get(target, BASE_PATH, "show", imageType.toString(), softwareVersionId);
  }
}
