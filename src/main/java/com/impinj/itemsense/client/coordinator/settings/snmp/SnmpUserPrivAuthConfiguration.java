package com.impinj.itemsense.client.coordinator.settings.snmp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SnmpUserPrivAuthConfiguration extends SnmpAuthConfiguration {

  private String engineId = "ITEMSENSE";
  private String userName;
  private String authenticationKey;
  private String privacyKey;

  public SnmpUserPrivAuthConfiguration() {
    setType(AuthType.V3_USER_PRIV);
  }
}
