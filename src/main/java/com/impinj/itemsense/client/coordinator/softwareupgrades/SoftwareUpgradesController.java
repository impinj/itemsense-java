package com.impinj.itemsense.client.coordinator.softwareupgrades;

import com.impinj.itemsense.client.helpers.RestApiHelper;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class SoftwareUpgradesController {

  private static final String BASE_PATH = "/control/v1/upgrades";
  private WebTarget target;

  public SoftwareUpgradesController(WebTarget target) {
    this.target = target;
  }

  public List<UpgradeRequestView> getUpgradeRequests() {
    return getUpgradeRequestsAsResponse()
        .readEntity(new GenericType<List<UpgradeRequestView>>() {});
  }

  public Response getUpgradeRequestsAsResponse() {
    return RestApiHelper.get(target, BASE_PATH, "show");
  }

  public UpgradeStatus getUpgradeStatus(String upgradeInstanceId) {
    return getUpgradeStatusAsResponse(upgradeInstanceId).readEntity(UpgradeStatus.class);
  }

  public Response getUpgradeStatusAsResponse(String upgradeInstanceId) {
    return RestApiHelper.get(
        target, BASE_PATH, "show", upgradeInstanceId
    );
  }

  public StartUpgradeResponse startUpgrade(UpgradeRequest upgradeRequest) {
    return startUpgradeAsResponse(upgradeRequest).readEntity(StartUpgradeResponse.class);
  }

  public Response startUpgradeAsResponse(UpgradeRequest upgradeRequest) {
    return RestApiHelper.post(upgradeRequest, target, BASE_PATH, "start");
  }

  /**
   * This API call will not return any information about the requested "stop" action.
   */
  public void stopUpgrade(String upgradeInstanceId) {
    RestApiHelper.post(target, BASE_PATH, "stop", upgradeInstanceId);
  }


}
