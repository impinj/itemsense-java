package com.impinj.itemsense.client.coordinator.settings.snmp;

import com.impinj.itemsense.client.helpers.RestApiHelper;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class SnmpController {

  private static final String BASE_PATH = "/configuration/v1/settings/SNMP";
  private WebTarget target;

  public SnmpController(WebTarget target) {
    this.target = target;
  }

  public Response updateSnmpConfigurationAsResponse(SnmpConfiguration snmpConfiguration) {
    return RestApiHelper.put(snmpConfiguration, target, BASE_PATH);
  }

  public Response getSnmpConfigurationAsResponse() {
    return RestApiHelper.get(target, BASE_PATH);
  }

  public Response deleteSnmpConfigurationAsResponse() {
    return RestApiHelper.delete(target, BASE_PATH);
  }

  public SnmpConfiguration getSnmpConfiguration() {
    return this.getSnmpConfigurationAsResponse()
        .readEntity(SnmpConfiguration.class);
  }

  public void deleteSnmpConfiguration() {
    this.deleteSnmpConfigurationAsResponse();
  }

  public SnmpConfiguration updateSnmpConfiguration(SnmpConfiguration snmpConfiguration) {
    return this.updateSnmpConfigurationAsResponse(snmpConfiguration)
        .readEntity(SnmpConfiguration.class);
  }
}
